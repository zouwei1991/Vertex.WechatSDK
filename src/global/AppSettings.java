package global;

public class AppSettings {

    //获取token
    public static final String Url_Get_AccessToken="https://qyapi.weixin.qq.com/cgi-bin/gettoken?corpid=%s&corpsecret=%s";

    public static final String Url_Get_IPList="https://qyapi.weixin.qq.com/cgi-bin/get_api_domain_ip?access_token=%s";

    public static final String Url_Post_Message="https://qyapi.weixin.qq.com/cgi-bin/message/send?access_token=%s";

    public static final String Url_Get_UserWithCode="https://qyapi.weixin.qq.com/cgi-bin/user/getuserinfo?access_token=%s&code=%s";

    public static final String Url_User_Add="https://qyapi.weixin.qq.com/cgi-bin/user/create?access_token=%s";

    public static final String Url_User_Get="https://qyapi.weixin.qq.com/cgi-bin/user/get?access_token=%s&userid=%s";

    public static final String Url_User_Update="https://qyapi.weixin.qq.com/cgi-bin/user/update?access_token=%s";

    public static final String Url_User_Delete="https://qyapi.weixin.qq.com/cgi-bin/user/delete?access_token=%s&userid=%s";

    public static final String Url_User_BatchDelete="https://qyapi.weixin.qq.com/cgi-bin/user/batchdelete?access_token=%s";

    public static final String Url_Get_Document="https://work.weixin.qq.com/api/doc/90000/90139/90313";

    public static final Boolean App_EnableValidate=false;

    public static final String Url_Post_SessionMessage="https://qyapi.weixin.qq.com/cgi-bin/appchat/send?access_token=%s";

    public static final String Url_Session_Create="https://qyapi.weixin.qq.com/cgi-bin/appchat/create?access_token=%s";

    public static final String Url_Session_Update="https://qyapi.weixin.qq.com/cgi-bin/appchat/update?access_token=%s";

    public static final String Url_Session_Get="https://qyapi.weixin.qq.com/cgi-bin/appchat/get?access_token=%s&chatid=%s";

    public static final String Url_Post_LinkedCorpMessage="https://qyapi.weixin.qq.com/cgi-bin/linkedcorp/message/send?access_token=%s";

    public static final String Url_Post_MessageStatistics="https://qyapi.weixin.qq.com/cgi-bin/message/get_statistics?access_token=%s";

    public static final String Url_Post_Media="https://qyapi.weixin.qq.com/cgi-bin/media/upload?access_token=%s&type=%s";

    public static final String Url_Post_Image="https://qyapi.weixin.qq.com/cgi-bin/media/uploadimg?access_token=%s";

    public static final String Url_Get_Media="https://qyapi.weixin.qq.com/cgi-bin/media/get?access_token=%s&media_id=%s";

    public static final String Url_Get_HDVoice="https://qyapi.weixin.qq.com/cgi-bin/media/get/jssdk?access_token=%s&media_id=%s";

    public static final String Url_Agent_Get="https://qyapi.weixin.qq.com/cgi-bin/agent/get?access_token=%s&agentid=%s";

    public static final String Url_Agent_Post="https://qyapi.weixin.qq.com/cgi-bin/agent/set?access_token=%s";

    public static final String Url_Menu_Get="https://qyapi.weixin.qq.com/cgi-bin/menu/get?access_token=%s&agentid=%s";

    public static final String Url_Menu_Post="https://qyapi.weixin.qq.com/cgi-bin/menu/create?access_token=%s&agentid=%s";

    public static final String Url_Menu_Delete="https://qyapi.weixin.qq.com/cgi-bin/menu/delete?access_token=%s&agentid=%s";
}
