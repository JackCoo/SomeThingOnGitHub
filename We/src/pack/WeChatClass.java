package pack;

import java.util.List;

import pack.DownLoadQrCodeThread.OnloadQrCodeFinnishListener;
import pack.HeartBeatThread.OnNewMsgListener;
import pack.WaitScanAndLoginThread.OnScanListener;

import com.google.gson.Gson;



public class WeChatClass {
	boolean isBeat=false;
	//************** 一些变量
	public String uuid;
	public String baseUrl;
	public String skey;
	public String wxsid;
	public String pass_ticket;
	public String wxuin;
	public String keyString;
	public BaseResponeBean initbean;
	//***************监听接口
	
	Gson gson=new Gson();
	private HttpClient hc=HttpClient.getInstance();
	private StringSubClass ss=new StringSubClass();
	private OnScanListener mScanListener;
	private OnNewMsgListener mNewMsgListener;
	private OnLoadQrCodeListener mQrCodeListener;
	
	
	//获取图片的byte数组，主要用于安卓端bitmap展示。pc可不用
	interface OnLoadQrCodeListener {
		void onLoadSuccess(byte[] imageBytes);
	}
	
	/**
	 * 必须先设置两个监听器，然后调用这个方法
	 */
	public void gogogo(){
		System.setProperty ("jsse.enableSNIExtension", "false");//避免ssl异常
		String result=hc.post("https://login.weixin.qq.com/jslogin",
				"appid=wx782c26e4c19acffb&fun=new&lang=zh_CN&_="+System.currentTimeMillis());
		uuid=ss.subStringOne(result, ".uuid = \"", "\";");//得到uuid
		//开启下载二维码的线程,安卓端需要把这里设置为false
		DownLoadQrCodeThread qrCodeThread=new DownLoadQrCodeThread("https://login.weixin.qq.com/qrcode/"+uuid+"?t=webwx&_=", true);
		qrCodeThread.setListener(new OnloadQrCodeFinnishListener() {
			
			@Override
			public void onLoadSuccess(byte[] imageBytes) {
				if (mQrCodeListener!=null) {
					mQrCodeListener.onLoadSuccess(imageBytes);
				}
				//二维码下载完成，开启轮询线程等待扫描二维码和登陆
				WaitScanAndLoginThread loginThread=new WaitScanAndLoginThread(uuid,WeChatClass.this);
				loginThread.setmScanListener(mScanListener);
				loginThread.start();
			}
		});
		qrCodeThread.start();
		
	}//uuid
	
	
	
	/**
	 * 在成功登陆后初始化微信相关参数
	 */
	 void init(){
		 for (int i = 0; i < 5; i++) {//开5个线程去初始化
			 new InitThread().start();
		}
		
	}
	
	
	
	/**
	 * 初始化后可选择性获取好友和群
	 */
	public void getFriendAndGroup(){
		String groupResult=hc.post(baseUrl+"/webwxgetcontact?r="+System.currentTimeMillis()+"&pass_ticket="+pass_ticket+"&skey="+skey,"{}");
		System.err.println(groupResult);
	}
	/**
	 * 同步syncKeys，每次获取到新消息后都要同步
	 */
	public void syncKeys(String reslut) {
		initbean=gson.fromJson(reslut, BaseResponeBean.class);
		keyString="";
		List<BaseResponeBean.SyncKeyEntity.ListEntity> keyList = initbean.getSyncKey().getList();
		for (BaseResponeBean.SyncKeyEntity.ListEntity listEntity : keyList) {
			keyString+=listEntity.getKey()+"_"+listEntity.getVal()+"|";
		}
		keyString=keyString.substring(0, keyString.length()-1);
	}
	
	//设置各种监听器
	public void setmScanListener(OnScanListener mScanListener) {
		this.mScanListener = mScanListener;
	}
	public void setmNewMsgListener(OnNewMsgListener mNewMsgListener) {
		this.mNewMsgListener = mNewMsgListener;
	}
	public void setmQrCodeListener(OnLoadQrCodeListener mQrCodeListener) {
		this.mQrCodeListener = mQrCodeListener;
	}
	class InitThread extends Thread{
		
			@Override
			public void run() {
				String data="{\"BaseRequest\":{\"Uin\":\""+wxuin+"\",\"Sid\":\""+wxsid+"\",\"Skey\":\""+skey+"\",\"DeviceID\":\"e982189146506998\"}}";
				hc.contentType="application/json";
				String initResult = hc.post(baseUrl+"/webwxinit?r="+System.currentTimeMillis(),
						data);				
				
				System.out.println("是否已开启心跳线程");
				if(!isBeat){
					//同步keys
					syncKeys(initResult);
					//开启心跳线程
					HeartBeatThread heartBeatThread=new HeartBeatThread(WeChatClass.this);
					heartBeatThread.setmNewMsgListener(mNewMsgListener);
					heartBeatThread.start();
					isBeat=true;
				}
			}
	}
	
}
