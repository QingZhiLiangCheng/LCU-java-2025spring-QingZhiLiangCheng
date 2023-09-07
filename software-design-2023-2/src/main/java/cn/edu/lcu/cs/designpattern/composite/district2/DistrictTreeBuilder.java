package cn.edu.lcu.cs.designpattern.composite.district2;


import java.util.UUID;

import static cn.edu.lcu.cs.designpattern.composite.district2.District.DistrictLevel.*;

public class DistrictTreeBuilder {
    /**
     * @return 构造好的一棵树
     */
    public static District build() {

        District tianqiao = new District(UUID.randomUUID().toString(), "天桥区", COUNTY);
        District huaiyin = new District(UUID.randomUUID().toString(), "槐阴区", COUNTY);
        District jinan = new District(UUID.randomUUID().toString(), "济南市", MUNICIPAL);
        jinan.add(tianqiao);
        jinan.add(huaiyin);

        District dongchangfu = new District(UUID.randomUUID().toString(), "东昌府区", COUNTY);
        District chiping = new District(UUID.randomUUID().toString(), "茌平区", COUNTY);
        District gaotang = new District(UUID.randomUUID().toString(), "高唐县", COUNTY);
        District liaocheng = new District(UUID.randomUUID().toString(), "聊城市", MUNICIPAL);
        liaocheng.add(dongchangfu);
        liaocheng.add(chiping);
        liaocheng.add(gaotang);

        District henan = new District(UUID.randomUUID().toString(), "河南省", PROVINCIAL);
        District shandong = new District(UUID.randomUUID().toString(), "山东省", PROVINCIAL);
        shandong.add(jinan);
        shandong.add(liaocheng);

        District districtTree = new District(UUID.randomUUID().toString(), "大中国", NATIONAL);
        districtTree.add(henan);
        districtTree.add(shandong);
        return districtTree;
    }
}
