package modules.agent;/*
 *@description
 *@author
 *@date
 */

import com.google.gson.annotations.SerializedName;
import common.WechatResponse;

public class AgentResponse extends WechatResponse {

    @SerializedName(value = "agentid")
    private int agentId;

    @SerializedName(value = "name")
    private String name;

    @SerializedName(value = "square_logo_url")
    private String squareLogoUrl;

    @SerializedName(value = "description")
    private String description;

    @SerializedName(value = "close")
    private int close;

    @SerializedName(value = "redirect_domain")
    private String redirectDomain;

    @SerializedName(value = "report_location_flag")
    private int reportLocationFlag;

    @SerializedName(value = "isreportenter")
    private int isReportenter;

    @SerializedName(value = "home_url")
    private String homeUrl;

    @SerializedName(value = "allow_userinfos")
    private AgnentUsers allowUsers;

    @SerializedName(value = "allow_partys")
    private AgentPartys agentPartys;

    @SerializedName(value = "allow_tags")
    private AgentTags agentTags;

    public int getAgentId() {
        return agentId;
    }

    public void setAgentId(int agentId) {
        this.agentId = agentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSquareLogoUrl() {
        return squareLogoUrl;
    }

    public void setSquareLogoUrl(String squareLogoUrl) {
        this.squareLogoUrl = squareLogoUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getClose() {
        return close;
    }

    public void setClose(int close) {
        this.close = close;
    }

    public String getRedirectDomain() {
        return redirectDomain;
    }

    public void setRedirectDomain(String redirectDomain) {
        this.redirectDomain = redirectDomain;
    }

    public int getReportLocationFlag() {
        return reportLocationFlag;
    }

    public void setReportLocationFlag(int reportLocationFlag) {
        this.reportLocationFlag = reportLocationFlag;
    }

    public int getIsReportenter() {
        return isReportenter;
    }

    public void setIsReportenter(int isReportenter) {
        this.isReportenter = isReportenter;
    }

    public String getHomeUrl() {
        return homeUrl;
    }

    public void setHomeUrl(String homeUrl) {
        this.homeUrl = homeUrl;
    }

    public AgnentUsers getAllowUsers() {
        return allowUsers;
    }

    public void setAllowUsers(AgnentUsers allowUsers) {
        this.allowUsers = allowUsers;
    }

    public AgentPartys getAgentPartys() {
        return agentPartys;
    }

    public void setAgentPartys(AgentPartys agentPartys) {
        this.agentPartys = agentPartys;
    }

    public AgentTags getAgentTags() {
        return agentTags;
    }

    public void setAgentTags(AgentTags agentTags) {
        this.agentTags = agentTags;
    }

    class AgnentUsers{

        @SerializedName(value = "user")
        private AgentUser[] users;

        public AgentUser[] getUsers() {
            return users;
        }

        public void setUsers(AgentUser[] users) {
            this.users = users;
        }
    }

    class AgentUser{

        @SerializedName(value = "userid")
        private String userId;

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }
    }

    class AgentPartys{

        @SerializedName(value = "partyid")
        private int[] partyIds;

        public int[] getPartyIds() {
            return partyIds;
        }

        public void setPartyIds(int[] partyIds) {
            this.partyIds = partyIds;
        }
    }

    class AgentTags{

        @SerializedName(value = "tagid")
        private int[] tagIds;

        public int[] getTagIds() {
            return tagIds;
        }

        public void setTagIds(int[] tagIds) {
            this.tagIds = tagIds;
        }
    }
}
