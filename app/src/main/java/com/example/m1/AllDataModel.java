package com.example.m1;

public class AllDataModel {


    String id, plan_id, title, company_name, description, video_description, duration, weekly_price, discounted_price, discounted_price_calculated, tax_price, tax_percentage, final_price, total_price, incentive_days, no_of_free_trial_days, no_of_video_session, plan_type, created_by_id, currency_code;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPlan_id() {
        return plan_id;
    }

    public void setPlan_id(String plan_id) {
        this.plan_id = plan_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVideo_description() {
        return video_description;
    }

    public void setVideo_description(String video_description) {
        this.video_description = video_description;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getWeekly_price() {
        return weekly_price;
    }

    public void setWeekly_price(String weekly_price) {
        this.weekly_price = weekly_price;
    }

    public String getDiscounted_price() {
        return discounted_price;
    }

    public void setDiscounted_price(String discounted_price) {
        this.discounted_price = discounted_price;
    }

    public String getDiscounted_price_calculated() {
        return discounted_price_calculated;
    }

    public void setDiscounted_price_calculated(String discounted_price_calculated) {
        this.discounted_price_calculated = discounted_price_calculated;
    }

    public String getTax_price() {
        return tax_price;
    }

    public void setTax_price(String tax_price) {
        this.tax_price = tax_price;
    }

    public String getTax_percentage() {
        return tax_percentage;
    }

    public void setTax_percentage(String tax_percentage) {
        this.tax_percentage = tax_percentage;
    }

    public String getFinal_price() {
        return final_price;
    }

    public void setFinal_price(String final_price) {
        this.final_price = final_price;
    }

    public String getTotal_price() {
        return total_price;
    }

    public void setTotal_price(String total_price) {
        this.total_price = total_price;
    }

    public String getIncentive_days() {
        return incentive_days;
    }

    public void setIncentive_days(String incentive_days) {
        this.incentive_days = incentive_days;
    }

    public String getNo_of_free_trial_days() {
        return no_of_free_trial_days;
    }

    public void setNo_of_free_trial_days(String no_of_free_trial_days) {
        this.no_of_free_trial_days = no_of_free_trial_days;
    }

    public String getNo_of_video_session() {
        return no_of_video_session;
    }

    public void setNo_of_video_session(String no_of_video_session) {
        this.no_of_video_session = no_of_video_session;
    }

    public String getPlan_type() {
        return plan_type;
    }

    public void setPlan_type(String plan_type) {
        this.plan_type = plan_type;
    }

    public String getCreated_by_id() {
        return created_by_id;
    }

    public void setCreated_by_id(String created_by_id) {
        this.created_by_id = created_by_id;
    }

    public String getCurrency_code() {
        return currency_code;
    }

    public void setCurrency_code(String currency_code) {
        this.currency_code = currency_code;
    }

    public AllDataModel(String id, String plan_id, String title, String company_name, String description, String video_description, String duration, String weekly_price, String discounted_price, String discounted_price_calculated, String tax_price, String tax_percentage, String final_price, String total_price, String incentive_days, String no_of_free_trial_days, String no_of_video_session, String plan_type, String created_by_id, String currency_code) {
        this.id = id;
        this.plan_id = plan_id;
        this.title = title;
        this.company_name = company_name;
        this.description = description;
        this.video_description = video_description;
        this.duration = duration;
        this.weekly_price = weekly_price;
        this.discounted_price = discounted_price;
        this.discounted_price_calculated = discounted_price_calculated;
        this.tax_price = tax_price;
        this.tax_percentage = tax_percentage;
        this.final_price = final_price;
        this.total_price = total_price;
        this.incentive_days = incentive_days;
        this.no_of_free_trial_days = no_of_free_trial_days;
        this.no_of_video_session = no_of_video_session;
        this.plan_type = plan_type;
        this.created_by_id = created_by_id;
        this.currency_code = currency_code;
    }
}
