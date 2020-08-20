package modules.agent;/*
 *@description
 *@author
 *@date
 */

import com.google.gson.annotations.SerializedName;

public class Agent {


    @SerializedName(value = "agentid")
    private int agentId;

    @SerializedName(value = "report_location_flag")
    private int reportLocationFlag;

    @SerializedName(value = "logo_mediaid")
    private String logoMediaId;

    @SerializedName(value = "name")
    private String name;

    @SerializedName(value = "description")
    private String description;

    @SerializedName(value = "redirect_domain")
    private String redirectDomain;

    @SerializedName(value = "isreportenter")
    private int isReportenter;

    @SerializedName(value = "home_url")
    private String homeUrl;

    public int getAgentId() {
        return agentId;
    }

    public void setAgentId(int agentId) {
        this.agentId = agentId;
    }

    public int getReportLocationFlag() {
        return reportLocationFlag;
    }

    public void setReportLocationFlag(int reportLocationFlag) {
        this.reportLocationFlag = reportLocationFlag;
    }

    public String getLogoMediaId() {
        return logoMediaId;
    }

    public void setLogoMediaId(String logoMediaId) {
        this.logoMediaId = logoMediaId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRedirectDomain() {
        return redirectDomain;
    }

    public void setRedirectDomain(String redirectDomain) {
        this.redirectDomain = redirectDomain;
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
}
