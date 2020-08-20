package modules.messages.common;/*
 *@description
 *@author
 *@date
 */

import com.google.gson.annotations.SerializedName;
import common.WechatResponse;

public class StatisticsMessageResponse extends WechatResponse {

    @SerializedName(value = "statistics")
    private StatisticsMessage[] statistics={};

    public StatisticsMessage[] getStatistics() {
        return statistics;
    }

    public void setStatistics(StatisticsMessage[] statistics) {
        this.statistics = statistics;
    }
}
