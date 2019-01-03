package com.zjc.TestDemo;

import org.hibernate.annotations.Formula;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * 公安案件实体类
 */
@Entity
@Table(name = "T_VR_AJ")
public class Gaaj {
    @Id
    @Column(name = "ID")
    @SequenceGenerator(name = "SEQ_VR_AJ", allocationSize = 1, sequenceName = "SEQ_VR_AJ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_VR_AJ")
    private String id;

    /**
     * 案件名称
     */
    @Column(name = "AJMC")
    private String ajmc;
    /**
     * 案发地点
     */
    @Column(name = "AFDD")
    private String afdd;
    /**
     * 案发时间段
     */
    @Column(name = "FASJKS")
    private Date fasjks;

    @Column(name = "FASJJS")
    private Date fasjjs;
    /**
     * 现场勘验号
     */
    @Column(name = "XCKYH")
    private String xckyh;
    /**
     * 报案人员姓名的字符串拼接
     */
    @Formula("(SELECT REPLACE(TO_CHAR(WM_CONCAT(AJ.XM)),',','、')  FROM T_VR_AJRY AJ WHERE AJ.SFYX_ST = '1' AND AJ.AJ_ID = ID AND AJ.RYLX = 'bar')")
    private String bary;
    /**
     * 涉案人员
     */
    @Column(name = "SARY")
    private String sary;
    /**
     * 立案的单位
     */
    @Column(name = "LADW_ID")
    private Integer ladwid;
    /**
     * 立案单位名称
     */
    @Column(name = "LADWMC")
    private String ladwmc;
    /**
     * 案件负责人
     */
    @Column(name = "AJFZR_ID")
    private String ajfzrId;
    /**
     * 案件负责人姓名
     */
    @Column(name = "AJFZRXM")
    private String ajfzrXm;

    /**
     * 案件详情
     */
    @Column(name = "AJXQ")
    private String ajxq;
    /**
     * 案件发现过程
     */
    @Column(name = "AJFXGC")
    private String ajfxgc;
    /**
     * 受害人
     */
    @Formula("(SELECT REPLACE(TO_CHAR(WM_CONCAT(AJ.XM)),',','、')  FROM T_VR_AJRY AJ WHERE AJ.SFYX_ST = '1' AND AJ.AJ_ID = ID AND AJ.RYLX = 'shr')")
    private String shr;


    /**
     * 修改时间
     */
    @Column(name = "XGSJ")
    private Date xgsj;

    /**
     * 创建时间
     */
    @Column(name = "CJSJ")
    private Date cjsj;
    /**
     * 修改人
     */
    @Column(name = "XGR_ID")
    private Long xgrId;

    /**
     * 创建人
     */
    @Column(name = "CJR_ID")
    private Long cjrId;

    /**
     * 案件类型备注
     */
    @Column(name = "AJLXBZ")
    private String ajlxbz;

    /**
     * 破案时间
     */
    @Column(name = "PASJ")
    private Date pasj;

    /**
     * 是否刑案
     */
    @Column(name = "SFXA")
    private String sfxa;

    /**
     * 是否命案
     *
     * @return
     */
    @Column(name = "SFMA")
    private String sfma;
    /**
     * 是否破案
     */
    @Column(name = "SFPA")
    private String sfpa;

    /**
     * (所在辖区)案事件区划
     *
     * @return
     */
    @Column(name = "SZXQ")
    private String szxq;

    /**
     * 辖区派出所id
     */
    @Column(name = "XQPCSID")
    private Integer xqpcsid;
    /**
     * 案件类型
     *
     * @return
     */
    @Column(name = "AJLX")
    private String ajlx;

    /**
     * 案件类型字典值
     */
    @Formula("(SELECT T.DICT_NAME FROM SYS_DICT T WHERE T.DICT_CODE = AJLX AND T.SFYX_ST = '1')")
    private String ajlxmc;
    /**
     * 案件类型子类
     */
    @Column(name = "SUBAJLX")
    private String subajlx;
    /**
     * 案件类型子类字典值
     */
    @Formula("(SELECT T.VALUE FROM SYS_SUBDICT T WHERE T.DICT_CODE = AJLX AND T.CODE = SUBAJLX AND T.SFYX_ST = '1')")
    private String subajlxmc;
    /**
     * 案件编号
     *
     * @return
     */
    @Column(name = "AJBH")
    private String ajbh;
    /**
     * 接警号
     *
     * @return
     */
    @Column(name = "JJH")
    private String jjh;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getAjmc() {
        return ajmc.trim();
    }

    public void setAjmc(String ajmc) {
        this.ajmc = ajmc.trim();
    }

    public String getAfdd() {
        return afdd;
    }

    public void setAfdd(String afdd) {
        this.afdd = afdd;
    }

    public Date getFasjks() {
        return fasjks;
    }

    public void setFasjks(Date fasjks) {
        this.fasjks = fasjks;
    }

    public Date getFasjjs() {
        return fasjjs;
    }

    public void setFasjjs(Date fasjjs) {
        this.fasjjs = fasjjs;
    }

    public String getBary() {
        return bary;
    }

    public void setBary(String bary) {
        this.bary = bary;
    }

    public String getSary() {
        return sary;
    }

    public void setSary(String sary) {
        this.sary = sary;
    }

    public String getLadwmc() {
        return ladwmc;
    }

    public void setLadwmc(String ladwmc) {
        this.ladwmc = ladwmc;
    }

    public String getAjfzrId() {
        return ajfzrId;
    }

    public void setAjfzrId(String ajfzrId) {
        this.ajfzrId = ajfzrId;
    }

    public String getAjfzrXm() {
        return ajfzrXm;
    }

    public void setAjfzrXm(String ajfzrXm) {
        this.ajfzrXm = ajfzrXm;
    }

    public String getAjxq() {
        return ajxq;
    }

    public void setAjxq(String ajxq) {
        this.ajxq = ajxq;
    }

    public String getShr() {
        return shr;
    }

    public void setShr(String shr) {
        this.shr = shr;
    }

    public Date getXgsj() {
        return xgsj;
    }

    public void setXgsj(Date xgsj) {
        this.xgsj = xgsj;
    }

    public Date getCjsj() {
        return cjsj;
    }

    public void setCjsj(Date cjsj) {
        this.cjsj = cjsj;
    }

    public Long getXgrId() {
        return xgrId;
    }

    public void setXgrId(Long xgrId) {
        this.xgrId = xgrId;
    }

    public Long getCjrId() {
        return cjrId;
    }

    public void setCjrId(Long cjrId) {
        this.cjrId = cjrId;
    }

    public Date getPasj() {
        return pasj;
    }

    public void setPasj(Date pasj) {
        this.pasj = pasj;
    }

    public String getSfxa() {
        return sfxa;
    }

    public void setSfxa(String sfxa) {
        this.sfxa = sfxa;
    }

    public String getSfma() {
        return sfma;
    }

    public void setSfma(String sfma) {
        this.sfma = sfma;
    }

    public String getAjlx() {
        return ajlx;
    }

    public void setAjlx(String ajlx) {
        this.ajlx = ajlx;
    }

    public String getAjbh() {
        return ajbh;
    }

    public void setAjbh(String ajbh) {
        this.ajbh = ajbh;
    }

    public String getJjh() {
        return jjh;
    }

    public void setJjh(String jjh) {
        this.jjh = jjh;
    }

    public String getAjlxbz() {
        return ajlxbz;
    }

    public void setAjlxbz(String ajlxbz) {
        this.ajlxbz = ajlxbz;
    }

    public Integer getLadwid() {
        return ladwid;
    }

    public void setLadwid(Integer ladwid) {
        this.ladwid = ladwid;
    }

    public String getSzxq() {
        return szxq;
    }

    public void setSzxq(String szxq) {
        this.szxq = szxq;
    }

    public Integer getXqpcsid() {
        return xqpcsid;
    }

    public void setXqpcsid(Integer xqpcsid) {
        this.xqpcsid = xqpcsid;
    }

    public String getAjfxgc() {
        return ajfxgc;
    }

    public void setAjfxgc(String ajfxgc) {
        this.ajfxgc = ajfxgc;
    }

    public String getSfpa() {
        return sfpa;
    }

    public void setSfpa(String sfpa) {
        this.sfpa = sfpa;
    }

    public String getSubajlx() {
        return subajlx;
    }

    public void setSubajlx(String subajlx) {
        this.subajlx = subajlx;
    }

    public String getXckyh() {
        return xckyh;
    }

    public void setXckyh(String xckyh) {
        this.xckyh = xckyh;
    }

    public String getSubajlxmc() {
        return subajlxmc;
    }

    public void setSubajlxmc(String subajlxmc) {
        this.subajlxmc = subajlxmc;
    }

    public String getAjlxmc() {
        return ajlxmc;
    }

    public void setAjlxmc(String ajlxmc) {
        this.ajlxmc = ajlxmc;
    }
}
