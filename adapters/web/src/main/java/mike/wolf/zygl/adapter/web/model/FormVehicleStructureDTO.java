package mike.wolf.zygl.adapter.web.model;

import lombok.Data;

/*
VehicleStructureJpaEntity
*/
@Data
public class FormVehicleStructureDTO {
        private String id;
        private int cc;  //车长
        private int ck;  //车宽
        private int cg;  //车高
        private int zj;  //轴距
        private int qlj;  //前轮距
        private int hlj;  //后轮距
        private String qdxs;  //驱动形式
        private String fxpwz;  //方向盘位置
        private String bsqxs;  //变数器形式
        private String description; // 备注
}
