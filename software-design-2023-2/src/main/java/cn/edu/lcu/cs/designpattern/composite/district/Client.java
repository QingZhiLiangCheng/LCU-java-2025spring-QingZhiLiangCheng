package cn.edu.lcu.cs.designpattern.composite.district;

import java.util.UUID;

import static cn.edu.lcu.cs.designpattern.composite.district.District.DistrictLevel.*;

public class Client {
    public static District buildDistrictTree() {
        CompositeDistrict districtTree = new CompositeDistrict(UUID.randomUUID().toString(), "大中国", null, NATIONAL);
        CompositeDistrict henan = new CompositeDistrict(UUID.randomUUID().toString(), "河南省", districtTree, PROVINCIAL);
        CompositeDistrict shandong = new CompositeDistrict(UUID.randomUUID().toString(), "山东省", districtTree, PROVINCIAL);

        CompositeDistrict  jinan = new CompositeDistrict(UUID.randomUUID().toString(), "济南市", shandong, MUNICIPAL);
        PrimaryLevelDistrict tianqiao = new PrimaryLevelDistrict(UUID.randomUUID().toString(), "天桥区", jinan, COUNTY);
        PrimaryLevelDistrict huaiyin = new PrimaryLevelDistrict(UUID.randomUUID().toString(), "槐阴区", jinan, COUNTY);

        CompositeDistrict liaocheng = new CompositeDistrict(UUID.randomUUID().toString(), "聊城市", shandong, MUNICIPAL);
        PrimaryLevelDistrict dongchangfu = new PrimaryLevelDistrict(UUID.randomUUID().toString(), "东昌府区", liaocheng, COUNTY);
        PrimaryLevelDistrict chiping = new PrimaryLevelDistrict(UUID.randomUUID().toString(), "茌平区", liaocheng, COUNTY);
        PrimaryLevelDistrict gaotang = new PrimaryLevelDistrict(UUID.randomUUID().toString(), "高唐县", liaocheng, COUNTY);

        return districtTree;
    }


    public static void main(String[] args) {
        District districtTree = buildDistrictTree();
        districtTree.traversal();
    }
}
