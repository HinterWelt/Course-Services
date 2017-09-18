package com.hinterwelt.course.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;
import java.util.Map;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * This is the entity for course from the VLE.
 * @author bilbo
 */
@XmlRootElement
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
public class Course {
    private int id;
    private String shortname;
    private int categoryid;
    private int categorysortorder;
    private String fullname;
    private String idnumber;
    private String summary;
    private int summaryformat;
    private String format;
    private int showgrades;
    private int newsitems;
    private int startdate;
    private int numsections;
    private int maxbytes;
    private int showreports;
    private int visible;
    private int hiddensections;
    private int groupmode;
    private int groupmodeforce;
    private int defaultgroupid;
    private int timecreated;
    private int timemodified;
    private int enablecompletion;
    private int completionnotify;
    private String lang;
    private String forcetheme;
    private List<Map<String, String>> courseformatoptions;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getShortname() {
        return shortname;
    }

    public void setShortname(String shortname) {
        this.shortname = shortname;
    }

    public int getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(int categoryid) {
        this.categoryid = categoryid;
    }

    public int getCategorysortorder() {
        return categorysortorder;
    }

    public void setCategorysortorder(int categorysortorder) {
        this.categorysortorder = categorysortorder;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getIdnumber() {
        return idnumber;
    }

    public void setIdnumber(String idnumber) {
        this.idnumber = idnumber;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public int getSummaryformat() {
        return summaryformat;
    }

    public void setSummaryformat(int summaryformat) {
        this.summaryformat = summaryformat;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public int getShowgrades() {
        return showgrades;
    }

    public void setShowgrades(int showgrades) {
        this.showgrades = showgrades;
    }

    public int getNewsitems() {
        return newsitems;
    }

    public void setNewsitems(int newsitems) {
        this.newsitems = newsitems;
    }

    public int getStartdate() {
        return startdate;
    }

    public void setStartdate(int startdate) {
        this.startdate = startdate;
    }

    public int getNumsections() {
        return numsections;
    }

    public void setNumsections(int numsections) {
        this.numsections = numsections;
    }

    public int getMaxbytes() {
        return maxbytes;
    }

    public void setMaxbytes(int maxbytes) {
        this.maxbytes = maxbytes;
    }

    public int getShowreports() {
        return showreports;
    }

    public void setShowreports(int showreports) {
        this.showreports = showreports;
    }

    public int getVisible() {
        return visible;
    }

    public void setVisible(int visible) {
        this.visible = visible;
    }

    public int getHiddensections() {
        return hiddensections;
    }

    public void setHiddensections(int hiddensections) {
        this.hiddensections = hiddensections;
    }

    public int getGroupmode() {
        return groupmode;
    }

    public void setGroupmode(int groupmode) {
        this.groupmode = groupmode;
    }

    public int getGroupmodeforce() {
        return groupmodeforce;
    }

    public void setGroupmodeforce(int groupmodeforce) {
        this.groupmodeforce = groupmodeforce;
    }

    public int getDefaultgroupid() {
        return defaultgroupid;
    }

    public void setDefaultgroupid(int defaultgroupid) {
        this.defaultgroupid = defaultgroupid;
    }

    public int getTimecreated() {
        return timecreated;
    }

    public void setTimecreated(int timecreated) {
        this.timecreated = timecreated;
    }

    public int getTimemodified() {
        return timemodified;
    }

    public void setTimemodified(int timemodified) {
        this.timemodified = timemodified;
    }

    public int getEnablecompletion() {
        return enablecompletion;
    }

    public void setEnablecompletion(int enablecompletion) {
        this.enablecompletion = enablecompletion;
    }

    public int getCompletionnotify() {
        return completionnotify;
    }

    public void setCompletionnotify(int completionnotify) {
        this.completionnotify = completionnotify;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getForcetheme() {
        return forcetheme;
    }

    public void setForcetheme(String forcetheme) {
        this.forcetheme = forcetheme;
    }

    public List<Map<String, String>> getCourseFormatOptions() {
        return courseformatoptions;
    }

    public void setCourseFormatOptions(List<Map<String, String>> courseformatoptions) {
        this.courseformatoptions = courseformatoptions;
    }
    
}
