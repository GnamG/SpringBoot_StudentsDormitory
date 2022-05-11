package com.fc.entity;

import java.util.Date;

public class Building {
    private String id;

    private Date createTime;

    private Date updateTime;

    private String valid;

    private Integer version;

    private String dormitoryManagerId;

    private String location;

    private String name;

    private String dormitoryManagerSn;

    private String dormitoryManagerName;

    public String getDormitoryManagerSn() {
        return dormitoryManagerSn;
    }

    public void setDormitoryManagerSn(String dormitoryManagerSn) {
        this.dormitoryManagerSn = dormitoryManagerSn;
    }

    public String getDormitoryManagerName() {
        return dormitoryManagerName;
    }

    public void setDormitoryManagerName(String dormitoryManagerName) {
        this.dormitoryManagerName = dormitoryManagerName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getValid() {
        return valid;
    }

    public void setValid(String valid) {
        this.valid = valid == null ? null : valid.trim();
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getDormitoryManagerId() {
        return dormitoryManagerId;
    }

    public void setDormitoryManagerId(String dormitoryManagerId) {
        this.dormitoryManagerId = dormitoryManagerId == null ? null : dormitoryManagerId.trim();
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location == null ? null : location.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}