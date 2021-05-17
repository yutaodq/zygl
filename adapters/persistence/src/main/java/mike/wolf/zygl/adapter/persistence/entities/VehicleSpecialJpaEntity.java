package mike.wolf.zygl.adapter.persistence.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "vehicle_special")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true) //如果加true，可以修改这个对象属性值

@Slf4j

public class VehicleSpecialJpaEntity {
    @Id
    private String id;

    @Column(name = "zdqzl_nb")
    private Number zdqzl;  //最大起重量

    @Column(name = "gjbj_nb")
    private Number gjbj;  //工作半径

    @Column(name = "zb_nb")
    private Number zb;  //主笔

    @Column(name = "zbc_nb")
    private Number zbc;  //主臂长

    @Column(name = "fbc_nb")
    private Number fbc;  //副臂长

    @Column(name = "fdjxh_tx")
    private String fdjxh;  //发动机型号

    @Column(name = "edgl_nb")
    private Number edgl;  //额定功率

    @Column(name = "zdnj_nb")
    private Number zdnj;  //最大扭矩

    @Column(name = "zgzs_nb")
    private Number qdxs;  //最高转速

    @Column(name = "rylx_tx")
    private String rylx;  //燃油类型

    @Column(name = "pjyh_nb")
    private Number pjyh;  //平均油耗

    @Column(name = "glxh_tx")
    private String glxh;  //锅炉型号

    @Column(name = "ysjxh_tx")
    private String ysjxh;  //压缩机型号

    @Column(name = "bxh_tx")
    private String bxh;  //泵型号

    @Column(name = "csyq_tx")
    private String csyq;  //测试仪器

    @Column(name = "dr_nb")
    private Number dr;  //斗容

    @Column(name = "bsqxs_tx")
    private String bsqxs;  //变数器形式

    @Column(name = "description_tx")
    private String description; // 备注
}
