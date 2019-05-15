package com.noteam.chinamapview;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends Activity {
    private static final String TAG = "MainActivity";

    int[] b;
    String c;
    private int selectdColor = 0xffEB5C47;
    float scale;
    float mapWidth = 1450;
    float mapHeight = 1200;
    int screenWidth;
     RelativeLayout rlMap;
Button dingwei;

     HVScaleScrollView scaleScrollView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dingwei=findViewById(R.id.dingwei);
        dingwei.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,Global.class);
                startActivity(intent);
            }
        });

        ChinaMapView chinaMapView =  findViewById(R.id.mapView);
        rlMap =  findViewById(R.id.rl_map);

         scaleScrollView = (HVScaleScrollView) findViewById(R.id.scrollView);

        chinaMapView.setSelectdColor(selectdColor);
        chinaMapView.setOnProvinceDoubleClickListener(new ChinaMapView.OnProvinceDoubleClickListener() {
            @Override
            public void onProvinceDoubleClick() {
                scaleAndScroll();
            }
        });
        
        chinaMapView.setOnProvinceSelectedListener(new ChinaMapView.OnProvinceSelectedListener() {
            @Override
            public void onProvinceSelected(ChinaMapView.Area pArea, boolean repeatClick) {
                if (repeatClick) {
                    scaleAndScroll();
                    return;
                }
                else if(pArea.name.equals("北京市")){
                     b=new int[]{R.mipmap.beijing,R.mipmap.beijing1,R.mipmap.beijing2,R.mipmap.beijing3,R.mipmap.beijing4};
                     c="北京（Beijing），简称京，中华人民共和国首都、直辖市、国家中心城市、超大城市，全国政治中心、文化中心、国际交往中心、科技创新中心，是中国共产党中央委员会、中华人民共和国中央人民政府和全国人民代表大会的办公所在地。北京位于东经115.7°—117.4°，北纬39.4°—41.6°，中心位于北39°54′20″，东经116°25′29″，总面积16412平方千米。北京位于华北平原北部，背靠燕山，毗邻天津市和河北省。北京的气候为典型的北温带半湿润大陆性季风气候。北京历史悠久，文化灿烂，是首批国家历史文化名城、中国四大古都之一和世界上拥有世界文化遗产数最多的城市，3060年的建城史孕育了故宫、天坛、八达岭长城、颐和园等众多名胜古迹。早在七十万年前，北京周口店地区就出现了原始人群部落“北京人”。公元前1045年，北京成为蓟、燕等诸侯国的都城。公元938年以来，北京先后成为辽陪都、金中都、元大都、明、清国都、中华民国北洋政府首都，1949年10月1日成为中华人民共和国首都。2019年1月11日，北京市级行政中心正式迁入北京城市副中心";
                    Intent intent=new Intent(MainActivity.this,DealAdapter.class);
                    intent.putExtra("country",b);
                    intent.putExtra("introduce",c);
                    startActivity(intent);
                }
                else if(pArea.name.equals("天津市")){
                    b=new int[]{R.mipmap.tianjin1,R.mipmap.tianjin2,R.mipmap.tianjin3,R.mipmap.tianjin4,R.mipmap.tianjin5};
                    c="天津，简称津，是中华人民共和国直辖市、国家中心城市、特大城市、环渤海地区经济中心、首批沿海开放城市，全国先进制造研发基地、北方国际航运核心区、金融创新运营示范区、改革开放先行区。天津自古因漕运而兴起，明永乐二年十一月二十一日（1404年12月23日）正式筑城，是中国古代唯一有确切建城时记录的城市。历经600多年，造就了天津中西合璧、古今兼容的独特城市风貌。 天津位于中国华北地区，界于东经116 °43′-118°4′、北纬38°34′-40°15′之间。东临渤海，西靠首都北京和河北，北部和南部与河北接壤，天津市总面积11916.85平方千米。 天津地处太平洋西岸，华北平原东北部，海河流域下游，海河五大支流南运河、子牙河、大清河、永定河、北运河的汇合处和入海口。天津市气候属典型的暖温带半湿润大陆性季风气候。 截至2017年底，天津市下辖16市辖区。 截至2018年末，天津市常住人口1559.60万人。全市生产总值（GDP）18809.64亿元，比上年增长3.6%";
                    Intent intent=new Intent(MainActivity.this,DealAdapter.class);
                    intent.putExtra("country",b);
                    intent.putExtra("introduce",c);
                    startActivity(intent);
                }
                else if(pArea.name.equals("上海市")){
                    b=new int[]{R.mipmap.shanghai1,R.mipmap.shanghai2,R.mipmap.shanghai3,R.mipmap.shanghai4,R.mipmap.shanghai5};
                    c="上海市，简称“沪”，是中国共产党的诞生地，是中华人民共和国省级行政区、直辖市，国家历史文化名城，国际经济、金融、贸易、航运、科技创新中心。 上海位于中国华东地区，界于东经120°52′-122°12′，北纬30°40′-31°53′之间，地处长江入海口，东隔东中国海与日本九州岛相望，南濒杭州湾，北、西与江苏、浙江两省相接，上海市总面积6340.5平方千米。上海地处太平洋西岸，亚洲大陆东岸，长江三角洲前缘，中国南北弧形海岸线中部，位于长江三角洲积平原，平均海拔高度4米。西部有天马山、薛山、凤凰山等残丘，天马山为陆境海拔最高点。上海地跨长江口、淀山湖、黄浦江、吴淞江四大水系，境内江、河湖、塘相间。上海属亚热带季风性气候，温和湿润，四季分明，日照充分，雨量充沛。截至2018年末，上海市常住人口总数为2423.78万人。实现地区生产总值（GDP）32679.87亿元，比上年增长6.6%";
                    Intent intent=new Intent(MainActivity.this,DealAdapter.class);
                    intent.putExtra("country",b);
                    intent.putExtra("introduce",c);
                    startActivity(intent);
                }
                else if(pArea.name.equals("重庆市")){
                    b=new int[]{R.mipmap.chongqing1,R.mipmap.chongqing2,R.mipmap.chongqing3,R.mipmap.chongqing4,R.mipmap.chongqing5};
                    c="重庆，简称巴和渝，别称巴渝、山城、渝都、桥都，雾都，是中华人民共和国中央直辖市、国家中心城市、超大城市、世界温泉之都、长江上游地区经济中心、金融中心和创新中心，政治、文化、科技、教育、艺术等中心，国务院定位的国际大都市。中西部水、陆、空型综合交通枢纽。 重庆因嘉陵江古称“渝水”，故重庆简称“渝”。北宋崇宁元年（1102年），改渝州为恭州。南宋淳熙16年（1189年）正月，孝宗之子赵惇先封恭王，二月即帝位为宋光宗皇帝，称为“双重喜庆”，遂升恭州为重庆府，重庆由此而得名。 抗日战争时期，中华民国政府定重庆为中华民国战时首都和永久陪都，共和国成立初期为西南大区驻地和中央直辖市，1997年6月18日恢复成立中央直辖市后，重庆老工业基地改造振兴步伐加快，形成了电子信息、汽车、装备制造、综合化工、材料、能源和消费品制造等千亿级产业集群，农业农村和金融、商贸物流、服务外包等现代服务业快速发展。 重庆拥有中新（重庆）战略性互联互通示范项目、国家级新区——两江新区、渝新欧国际铁路、重庆两路寸滩保税港区、重庆西永综合保税区、重庆铁路保税物流中心、重庆南彭公路保税物流中心、万州保税物流中心、过境72小时内免签，进口整车、水果、肉类等口岸";
                    Intent intent=new Intent(MainActivity.this,DealAdapter.class);
                    intent.putExtra("country",b);
                    intent.putExtra("introduce",c);
                    startActivity(intent);
                }
                else if(pArea.name.equals("河北省")){
                    b=new int[]{R.mipmap.hebei1,R.mipmap.hebei2,R.mipmap.hebei3,R.mipmap.hebei4,R.mipmap.hebei5};
                   c="河北省，古属冀州、直隶， 简称“冀”，辖11个地级市，省会石家庄。地处华北、漳河以北，东临渤海、内环京津，西为太行山，北为燕山，燕山以北为张北高原。5000年前，黄帝、蚩尤涿鹿之战，开启中华文明之先河。春秋战国时期河北属于燕国、赵国。 汉代河北属幽州、冀州。元代河北为中央直属的中书省。清代属直隶省。 解放战争时期，河北西柏坡为中共中央所在地。 河北是中华民族的发祥地之一，省级以上文物保护单位达930处，居全国第一位。拥有长城、承德避暑山庄、清东陵和清西陵3项世界文化遗产；拥有邯郸、保定、承德、正定、山海关5个国家级历史文化名城。河北是长城途经距离最长、保存最完好的省份，境内长城遗存达2000多公里。 河北的唐山港、黄骅港、秦皇岛港均跻身亿吨大港行列。铁路、公路货物周转量居中国大陆首位。2013年，京津冀一体化上升为重大国家战略。2015年7月31日，国际奥委会主席巴赫宣布北京携手河北省张家口获得2022年冬奥会举办权";
                    Intent intent=new Intent(MainActivity.this,DealAdapter.class);
                    intent.putExtra("country",b);
                    intent.putExtra("introduce",c);
                    startActivity(intent);
                }
                else if(pArea.name.equals("山西省")){
                    b=new int[]{R.mipmap.shanxi1,R.mipmap.shanxi2,R.mipmap.shanxi3,R.mipmap.shanxi4,R.mipmap.shanxi5};
                    c="山西，因居太行山之西而得名，简称“晋”，又称“三晋”，省会太原市。“东依太行山，西、南依吕梁山、黄河，北依古长城，与河北、河南、陕西、内蒙古等省区为界”柳宗元称之为“表里山河”。山西是中华民族发祥地之一，山西有文字记载的历史达三千年，被誉为“华夏文明摇篮”，素有“中国古代文化博物馆”之称。总面积15.67万平方公里，东有太行山，西有吕梁山，山区面积约占全省总面积的80%以上。山西行政区轮廓略呈东北斜向西南的平行四边形，下辖11个地级市，119个县级行政单位（23个市辖区、11个县级市、85个县），总人口3610.8万（2012年）。辖区地理坐标为北纬34°34′~40°44′，东110°14′~114°33′";
                    Intent intent=new Intent(MainActivity.this,DealAdapter.class);
                    intent.putExtra("country",b);
                    intent.putExtra("introduce",c);
                    startActivity(intent);
                }
                else if(pArea.name.equals("辽宁省")){
                    b=new int[]{R.mipmap.liaoning1,R.mipmap.liaoning2,R.mipmap.liaoning3,R.mipmap.liaoning4,R.mipmap.liaoning5};
                    c="辽宁省，简称\"辽\"，省会沈阳，辖14个地级市，其中副省级城市2个(沈阳、大连)，位于中国东北地区南部，南临黄海、渤海，东与朝鲜一江之隔，与日本、韩国隔海相望，是东北地区唯一的既沿海又沿边的省份，也是东北及内蒙古自治区东部地区对外开放的门户。辽宁是中国重要的老工业基地，是全国工业门类较为齐全的省份之一，是中国最早实行对外开放政策的沿海省份之一，也是中国近代开埠最早的省份之一，是中华民族和中华文明的发源地之一，新中国工业崛起的摇篮，被誉为\"共和国长子\"、\"东方鲁尔\"。2013年8月31日在辽宁召开了全国第十二届运动会，吉祥物为斑海豹\"宁宁\"";
                    Intent intent=new Intent(MainActivity.this,DealAdapter.class);
                    intent.putExtra("country",b);
                    intent.putExtra("introduce",c);
                    startActivity(intent);
                }

                else if(pArea.name.equals("吉林省")){
                    b=new int[]{R.mipmap.jilin1,R.mipmap.jilin2,R.mipmap.jilin3,R.mipmap.jilin4,R.mipmap.jilin5};
                   c="吉林省简称“吉”，省会长春市。地处东经122-131度、北纬41-46度之间，面积18.74万平方公里，占全国面积2%。位于中国东北中部，处于日本、俄罗斯、朝鲜、韩国、蒙古与中国东北部组成的东北亚几何中心地带。北接黑龙江省，南接辽宁省，西邻内蒙古自治区，东与俄罗斯接壤，东南部以图们江、鸭绿江为界，与朝鲜民主主义人民共和国隔江相望。东西长650公里，南北宽300公里。东南部高，西北部低，中西部是广阔的平原。 吉林省气候属温带季风气候，有比较明显的大陆性。夏季高温多雨，冬季寒冷干燥。吉林是中国重要的工业基地，加工制造业比较发达，汽车与石化、农产品加工为三大支柱产业，装备制造、光电子信息、医药、冶金建材、轻工纺织具有自身优势特色。 吉林省辖长春（副省级市）、吉林、四平、松原、白城、辽源、通化、白山和延边朝鲜族自治州。另直管梅河口、公主岭2个县级市。2018年8月，吉林省出台《关于推进避暑休闲产业创新发展的实施意见》提出，到2020年，吉林将基本建设成为国内首选的避暑休闲名省，建成避暑名城10个以上，打造特色避暑名镇20个以上";
                    Intent intent=new Intent(MainActivity.this,DealAdapter.class);
                    intent.putExtra("country",b);
                    intent.putExtra("introduce",c);
                    startActivity(intent);
                }
                else if(pArea.name.equals("黑龙江省")){
                    b=new int[]{R.mipmap.heilongjiang1,R.mipmap.heilongjiang2,R.mipmap.heilongjiang3,R.mipmap.heilongjiang4,R.mipmap.heilongjiang5};
                    c="黑龙江省，简称黑，省会哈尔滨，位于中国最东北部，中国国土的北端与东端均位于省境。因省境东北有黑龙江而得名。 黑龙江东部和北部以乌苏里江黑龙江为界河与俄罗斯为邻，与俄罗斯的水陆边界长约3045公里；西接内蒙古自治区，南连吉林省。介于北纬43°26′~53°33′，东经121°11′~135°05′，南北长约1120公里，东西宽约930公里，面积47．3万平方公里。 黑龙江辖1个副省级市（哈尔滨）、1个较大的市（齐齐哈尔）、10个地级市、1个地区，以及64个市辖区、18个县级市、45个县、1个自治县。黑龙江西部属松嫩平原，东北部为三江平原，北部、东南部为山地，多处平原海拔50～200米。 黑龙江是中国重工业基地，工业门类以机械、石油、煤炭、木材和食品工业为主";
                    Intent intent=new Intent(MainActivity.this,DealAdapter.class);
                    intent.putExtra("country",b);
                    intent.putExtra("introduce",c);
                    startActivity(intent);
                }
                else if(pArea.name.equals("黑龙江省")){
                    b=new int[]{R.mipmap.heilongjiang1,R.mipmap.heilongjiang2,R.mipmap.heilongjiang3,R.mipmap.heilongjiang4,R.mipmap.heilongjiang5};
                    c="黑龙江省，简称黑，省会哈尔滨，位于中国最东北部，中国国土的北端与东端均位于省境。因省境东北有黑龙江而得名。 黑龙江东部和北部以乌苏里江黑龙江为界河与俄罗斯为邻，与俄罗斯的水陆边界长约3045公里；西接内蒙古自治区，南连吉林省。介于北纬43°26′~53°33′，东经121°11′~135°05′，南北长约1120公里，东西宽约930公里，面积47．3万平方公里。 黑龙江辖1个副省级市（哈尔滨）、1个较大的市（齐齐哈尔）、10个地级市、1个地区，以及64个市辖区、18个县级市、45个县、1个自治县。黑龙江西部属松嫩平原，东北部为三江平原，北部、东南部为山地，多处平原海拔50～200米。 黑龙江是中国重工业基地，工业门类以机械、石油、煤炭、木材和食品工业为主";
                    Intent intent=new Intent(MainActivity.this,DealAdapter.class);
                    intent.putExtra("country",b);
                    intent.putExtra("introduce",c);
                    startActivity(intent);
                }
                else if(pArea.name.equals("江苏省")){
                    b=new int[]{R.mipmap.jiangsu1,R.mipmap.jiangsu2,R.mipmap.jiangsu3,R.mipmap.jiangsu4,R.mipmap.jiangsu5};
                    c="江苏，简称“苏”，省会南京，位于中国大陆东部沿海中心，介于东经116°18′～121°57′，北纬30°45′～35°20′之间。公元1667年因江南省东西分置而建省，得名于“江宁府”与“苏州府”之首字。 江苏省际陆地边界线3383公里，面积10.72万平方公里，占中国的1.12%，人均国土面积在中国各省区中最少。江苏地形以平原为主，平原面积达7万多平方公里，占江苏面积的70%以上，比例居中国各省首位。2014年，江苏常住人口达7960.06万人，居中国第5位。2014年，江苏13市GDP全部进入中国前100名，人均GDP达81874元，居中国各省首位。 江苏辖江临海，扼淮控湖，经济繁荣，教育发达，文化昌盛。地跨长江、淮河南北，京杭大运河从中穿过，拥有吴、金陵、淮扬、中原四大多元文化，是中国古代文明的发祥地之一。江苏地理上跨越南北，气候、植被也同时具有南方和北方的特征。江苏东临黄海、太平洋，与上海市、浙江省、安徽省、山东省接壤， 与日本九州岛、韩国济州岛、美国第一大州加利福尼亚州隔海相望 ，已与加利福尼亚州缔结为姐妹省州 ，成立了“江苏省-加利福尼亚州”联合经济委员会 。江苏与上海、浙江、安徽共同构成的长江三角洲城市群已成为国际6大世界级城市群之一 。江苏人均GDP、综合竞争力、地区发展与民生指数（DLI）均居全国各省第一 ，成为中国综合发展水平最高的省份 ，已步入“中上等”发达国家水平";
                    Intent intent=new Intent(MainActivity.this,DealAdapter.class);
                    intent.putExtra("country",b);
                    intent.putExtra("introduce",c);
                    startActivity(intent);
                }
                else if(pArea.name.equals("浙江省")){
                    b=new int[]{R.mipmap.zhejiang1,R.mipmap.zhejiang2,R.mipmap.zhejiang3,R.mipmap.zhejiang4,R.mipmap.zhejiang5};
                    c="浙江省地处中国东南沿海长江三角洲南翼，东临东海，南接福建，西与安徽、江西相连，北与上海、江苏接壤。境内最大的河流钱塘江，因江流曲折，称之江、折江，又称浙江，省以江名，简称“浙”，浙江省东西和南北的直线距离均为450公里左右。据全国第二次土地调查结果，浙江土地面积10.55万平方公里，为全国的1.10%，是中国面积最小的省份之一。 浙江是吴越文化、江南文化的发源地，是中国古代文明的发祥地之一。早在5万年前的旧石器时代，就有原始人类“建德人”活动，境内有距今7000年的河姆渡文化、距今6000年的马家浜文化和距今5000年的良渚文化，是典型的山水江南、鱼米之乡，被称为“丝绸之府”、“鱼米之乡”。浙江是中国经济最活跃的省份之一，在充分发挥国有经济主导作用的前提下，以民营经济的发展带动经济的起飞，形成了具有鲜明特色的“浙江经济”，至2013年人均居民可支配收入连续21年位居中国第一。浙江与江苏、安徽、上海共同构成的长江三角洲城市群已成为国际6大世界级城市群之一。浙江省下辖杭州、宁波、温州、绍兴、湖州、嘉兴、金华、衢州、舟山、台州、丽水11个城市，其中杭州、宁波（计划单列市）为副省级城市；下分90个县级行政区，包括36个市辖区、20个县级市、34个县（含1个自治县）";
                    Intent intent=new Intent(MainActivity.this,DealAdapter.class);
                    intent.putExtra("country",b);
                    intent.putExtra("introduce",c);
                    startActivity(intent);
                }
                else if(pArea.name.equals("安徽省")){
                    b=new int[]{R.mipmap.anhui1,R.mipmap.anhui2,R.mipmap.anhui3,R.mipmap.anhui4,R.mipmap.anhui5};
                   c="安徽省，简称皖，省会合肥市，位于中国大陆东部，介于东经114°54′-119°37′，北纬29°41′-34°38′之间，公元1667年因江南省东西分置而建省。得名于“安庆府”与“徽州府”之首字。 安徽省地跨长江、淮河南北，与江苏省、浙江省、湖北省、河南省、江西省、山东省接壤，东西宽约450公里，南北长约570公里，土地面积13.94万平方公里，占全国的1.45%。地形地貌由淮北平原、江淮丘陵、皖南山区组成。 境内的巢湖是中国五大淡水湖之一。安徽是中国史前文明的重要发祥地，拥有淮河、新安、庐州、皖江四大文化圈。 安徽省自古重视科研，是国家技术创新工程试点省。古今有毕昇、梅文鼎、邓稼先、杨振宁等科学家，截至2014年拥有中国科学技术大学为首的科研教育大学107所，科研机构3484个，部属以上实验室186个，省级以上工程（技术）研究中心554家。 安徽省与江苏省、上海市、浙江省共同构成的长江三角洲城市群已成为国际6大世界级城市群之一。安徽创造的“小岗村精神”，拉开了中国农村改革开放的序幕。2015年，安徽省正式迈入中等偏上收入的快速发展阶段。2014年获得中国最幸福的省份荣誉，被列入中国首个新型城镇化试点省份。徽商是中国十大商帮之一，鼎盛时期徽商曾经占有全国总资产的4/7，亦儒亦商，辛勤力耕，赢得了“徽骆驼”的美称。2015年，安徽省正式迈入中等偏上收入的快速发展阶段。";
                    Intent intent=new Intent(MainActivity.this,DealAdapter.class);
                    intent.putExtra("country",b);
                    intent.putExtra("introduce",c);
                    startActivity(intent);
                }
                else if(pArea.name.equals("福建省")){
                    b=new int[]{R.mipmap.fujian1,R.mipmap.fujian2,R.mipmap.fujian3,R.mipmap.fujian4,R.mipmap.fujian5};
                    c="福建，简称“闽”，位于中国东南沿海，东北与浙江省毗邻，西面、西北与江西省接界，西南与广东省相连，东面隔台湾海峡与台湾省相望。南北最长为530千米，东西最宽为480千米。福建省现辖福州、厦门、莆田、泉州、漳州、龙岩、三明、南平、宁德9个  设区市和平潭综合实验区（平潭县）。省会为福州。福建的地理特点是“依山傍海”，九成陆地面积为山地丘陵地带，被称为“八山一水一分田”。福建的森林覆盖率达65.95%，居全国第一。福建的海岸线长度居全国第二位，海岸曲折，陆地海岸线长达3751.5千米。福建以侵蚀海岸为主，岛屿众多，岛屿星罗棋布，共有岛屿1500多个，海坛岛现为全省第一大岛。而且由于福建位于东海与南海的交通要冲，由海路可以到达南亚、西亚、东非，是历史上海上丝绸之路、郑和下西洋的起点，也是海上商贸集散地，和中国其他地方不同，福建沿海的文明是海洋文明，而内地客家地区是农业文明。依山傍海的特点也造就了福建丰富的旅游资源；而且除了海坛岛、鼓浪屿、武夷山、泰宁、清源山、白水洋、太姥山等自然风光外，还有土楼、安平桥、三坊七巷等人文景观。福建的民族组成比较单一，汉族占总人口的97.84%，畲族为最主要的少数民族，占总人口1%，还有少量回族、满族等，其它民族人口多为近现代迁居而来，比重极小。福建汉族内部语言文化高度多元，分化成多个族群";
                    Intent intent=new Intent(MainActivity.this,DealAdapter.class);
                    intent.putExtra("country",b);
                    intent.putExtra("introduce",c);
                    startActivity(intent);
                }
                else if(pArea.name.equals("江西省")){
                    b=new int[]{R.mipmap.jiangxi1,R.mipmap.jiangxi2,R.mipmap.jiangxi3,R.mipmap.jiangxi4,R.mipmap.jiangxi5};
                    c="江西省，中国省级行政区，简称赣(gàn)，别称赣鄱大地，是江南\"鱼米之乡\"，古有\"吴头楚尾，粤户闽庭\"之称。因公元733年唐玄宗设江南西道而得省名，又因省内最大河流为赣江而简称赣。江西省地处北纬24°29′14″至30°04′41″，东经113°34′36″至118°28′58″之间，东邻浙江省、福建省，南连广东省，西接湖南省，北毗湖北省、安徽省而共接长江，属于华东地区。江西省全省面积16.69万平方公里，辖11个地级市、100个县(市、区)，省会为南昌市。省内除北部较为平坦外，东西南部三面环山，中部丘陵起伏，成为一个整体向鄱阳湖倾斜而往北开口的巨大盆地。全境有大小河流2400余条，赣江、抚河、信江、修河和饶河为江西五大河流。鄱阳湖是中国第一大淡水湖。江西处北回归线附近，全省气候温暖，雨量充沛，年均降水量1341毫米到1940毫米;无霜期长，为亚热带湿润气候。江西粮食作物以稻子为主，次为小麦。还盛产油菜、油茶、茶叶、黄麻、苎麻和柑橘。茶叶多产于北部山地，\"宁红\"、\"婺绿\"均为茶中名产。主要工业为有色冶金、煤炭、钢铁、机械制造、化肥等。景德镇的瓷器工艺历史悠久，产品驰名中外。2015年，江西省GDP达16723.8亿元。1%人口抽样调查结果显示，2015年末，江西省常住人口为4565.63万人，较2014年增长了0.52%。江西省汉语方言主要有赣语、客家语、江淮官话、西南官话、吴语、徽语 。";
                    Intent intent=new Intent(MainActivity.this,DealAdapter.class);
                    intent.putExtra("country",b);
                    intent.putExtra("introduce",c);
                    startActivity(intent);
                }
                else if(pArea.name.equals("山东省")){
                    b=new int[]{R.mipmap.shandong1,R.mipmap.shandong2,R.mipmap.shandong3,R.mipmap.shandong4,R.mipmap.shandong5};
                    c="山东，因居太行山以东而得名，简称“鲁”，省会济南。先秦时期隶属齐国、鲁国，故而别名齐鲁。山东地处华东沿海、黄河下游、京杭大运河中北段，是华东地区的最北端省份。西部连接内陆，从北向南分别与河北、河南、安徽、江苏四省接壤；中部高突，泰山是全境最高点；东部山东半岛伸入黄海，北隔渤海海峡与辽东半岛相对、拱卫京津与渤海湾，东隔黄海与朝鲜半岛相望，东南则临靠较宽阔的黄海、遥望东海及日本南部列岛。 山东是儒家文化发源地，儒家思想的创立人孔子、孟子，以及墨家思想的创始人墨子、和文化的创始人柳下惠、军事家吴起等，均出生于鲁国。姜太公在临淄（今淄博市临淄区）建立齐国，成就了齐桓公、管仲、晏婴、鲍叔牙、孙武、孙膑等一大批志士名人；齐国还创建了世界上第一所官方举办、私家主持的高等学府——稷下学宫。 山东是中国的经济大省、人口第二大省、中国温带水果之乡，国内生产总值列全国第三，占中国GDP总量的1/9。2013年，山东与广东、江苏，一起被评为中国最具综合竞争力省区。山东是第十届中国艺术节，中华人民共和国第十一届运动会，第三届亚洲沙滩运动会，2014年世界杯帆船赛、世界园艺博览会、APEC贸易部长会议，2015年世界休闲体育大会、国际历史科学大会、2018年上海合作组织青岛峰会举办地。2017年全省实现生产总值72678.18亿元，山东人均GDP达到72851元";
                    Intent intent=new Intent(MainActivity.this,DealAdapter.class);
                    intent.putExtra("country",b);
                    intent.putExtra("introduce",c);
                    startActivity(intent);
                }
                else if(pArea.name.equals("河南省")){
                    b=new int[]{R.mipmap.henan1,R.mipmap.henan2,R.mipmap.henan3,R.mipmap.henan4,R.mipmap.henan5};
                   c="河南，古称中原、豫州、中州，简称“豫”，因大部分位于黄河以南，故名河南。河南位于中国中东部、黄河中下游，东接安徽、山东，北界河北、山西，西连陕西，南临湖北，呈望北向南、承东启西之势。截至2014年底，河南共下辖17个地级市，1个省直管县级市，省会郑州。河南省总人口10662万人，常住人口9436万人。河南是中华民族与中华文明的主要发祥地之一，中国古代四大发明中的指南针、造纸、火药三大技术均发明于河南。 历史上先后有20多个朝代建都或迁都河南，诞生了洛阳、开封、安阳、郑州、商丘等古都，为中国古都数量最多最密集的省区。河南有老子、庄子、墨子、韩非子、商鞅、张良、张衡、杜甫、吴道子、岳飞等历史名人。河南是中国重要的经济大省，2016年国内生产总值稳居中国第5位、中西部地区首位。郑州商品交易所是中国首家内陆唯一一家期货交易所。郑州航空港区为中国唯一一个国家级航空港经济实验区。中国（河南）自由贸易试验区为中国新设立的自贸区。2016年12月，国家批复郑州入选国家中心城市。 以河南为主体的中原城市群为中国经济第四增长极。河南文物古迹众多，旅游资源丰富。截至2017年，河南有世界文化遗产6项25处，全国重点文物保护单位358处，国家AAAAA级旅游景区13处";
                    Intent intent=new Intent(MainActivity.this,DealAdapter.class);
                    intent.putExtra("country",b);
                    intent.putExtra("introduce",c);
                    startActivity(intent);
                }
                else if(pArea.name.equals("湖北省")){
                    b=new int[]{R.mipmap.hubei1,R.mipmap.hubei2,R.mipmap.hubei3,R.mipmap.hubei4,R.mipmap.hubei5};
                    c="湖北省，位于中国中部偏南、长江中游，洞庭湖以北，故名湖北，简称“鄂”，省会武汉。湖北介于北纬29°05′至33°20′，东经108°21′至116°07′，东连安徽，南邻江西、湖南，西连重庆，西北与陕西为邻，北接河南。湖北东、西、北三面环山，中部为“鱼米之乡”的江汉平原。 湖北是承东启西、连南接北的交通枢纽，武汉天河国际机场是中国内陆重要的空港。长江自西向东，横贯全省1062公里。长江及其最大支流汉江，润泽楚天，水网纵横，湖泊密布，湖北省因此又称“千湖之省”。湖北文化底蕴深厚，中华民族的始祖炎帝的故里在湖北。春秋战国时期的楚国在长达800多年的历史中，创造了楚文化。湖北具有光荣的革命传统。从武昌辛亥首义到新中国成立，湖北为中国革命胜利作出了重要贡献。新民主主义革命时期，仅红安县就孕育了董必武、李先念两位国家主席和200多位将军。湖北省科教文化实力位居全国前列，是中国重要的高等教育基地。湖北省科学研究水平全国领先，国家科技奖获奖项目数量，连续7年位居全国前四";
                    Intent intent=new Intent(MainActivity.this,DealAdapter.class);
                    intent.putExtra("country",b);
                    intent.putExtra("introduce",c);
                    startActivity(intent);
                }
                else if(pArea.name.equals("湖南省")){
                    b=new int[]{R.mipmap.hunan1,R.mipmap.hunan2,R.mipmap.hunan3,R.mipmap.hunan4,R.mipmap.hunan5};
                    c="湖南省地处中国中部、长江中游，因大部分区域处于洞庭湖以南而得名“湖南”，因省内最大河流湘江流贯全境而简称“湘”，省会驻长沙市。湖南东临江西，西接重庆、贵州，南毗广东、广西，北与湖北相连。土地面积21.18万平方公里，占中国国土面积的2.2%，在各省市区面积中居第10位。全省总人口6737.2万人（2014年）。辖14个地州市、122个县（市、区）。湖南自古盛植木芙蓉，五代时就有“秋风万里芙蓉国”之说，因此又有“芙蓉国”之称。唐朝谭用之有诗“秋风万里芙蓉国”咏之，毛泽东更是用“芙蓉国里尽朝晖”赞美湖南。湖南自古有“惟楚有材，于斯为盛”之誉。近现代以来，先后涌现了启蒙思想家魏源，清代中兴名臣曾国藩、左宗棠，维新志士谭嗣同、唐才常，辛亥元勋黄兴、蔡锷、宋教仁等。新民主主义革命时期，湖南发生了秋收起义、湘南暴动、桑植起义、平江起义、通道转兵、芷江受降等著名历史事件。毛泽东、刘少奇、任弼时、彭德怀等无产阶级革命家，为创建中国共产党、缔造中华人民共和国做出了卓越贡献；新中国授衔的十大元帅、十大将军有九位是湖南人。建国后又涌现出胡耀邦、朱镕基等党和国家领导人。此外，从“试管婴儿之母”卢光琇等著名科学家，到田汉、齐白石、黄永玉等知名艺术家；从沈从文、周立波等著名文学家，熊倪、刘璇等世界体育名将，到共产主义战士雷锋；湖湘人才联袂而起、灿若星河";
                    Intent intent=new Intent(MainActivity.this,DealAdapter.class);
                    intent.putExtra("country",b);
                    intent.putExtra("introduce",c);
                    startActivity(intent);
                }
                else if(pArea.name.equals("广东省")){
                    b=new int[]{R.mipmap.guangdong1,R.mipmap.guangdong2,R.mipmap.guangdong3,R.mipmap.guangdong4,R.mipmap.guangdong5};
                    c="广东省，以岭南东道、广南东路得名，简称“粤”，省会广州，是中国大陆南端沿海的一个省份，位于南岭以南，南海之滨，与香港、澳门、广西、湖南、江西和福建接壤，与海南隔海相望，划分为珠三角、粤东、粤西和粤北四个区域，下辖21个地级市（其中副省级城市2个），119个县级行政区（60个市辖区、20个县级市、36个县、3个自治县）。广东省在秦以前，作为中华民族先民的南越族人民已从事农业活动，是中国历史上商品性农业最早发展的地区之一，也是中国最早出现资本主义生产方式的省份之一。至1987年，广东省工业产值已占全省工农业总值的79.6%，成为国民经济的主导部门，食品、机械、化工、纺织缝纫业成为广东省支柱工业部门。自1989年起，广东国内生产总值在中国30个省市中，连续占居第一位 。广东省已成为中国第一经济大省，经济总量占全国的1/8，并超越香港和台湾，成为中国经济规模最大，经济综合竞争力、金融实力最强省份，并已达到中上等收入国家水平、中等发达国家水平";
                    Intent intent=new Intent(MainActivity.this,DealAdapter.class);
                    intent.putExtra("country",b);
                    intent.putExtra("introduce",c);
                    startActivity(intent);
                }
                else if(pArea.name.equals("海南省")){
                    b=new int[]{R.mipmap.hainan1,R.mipmap.hainan2,R.mipmap.hainan3,R.mipmap.hainan4,R.mipmap.hainan5};
                    c="海南省，简称琼，别称琼州，位于中国南端。海南省是中国国土面积(陆地面积加海洋面积)第一大省，海南经济特区是中国最大的省级经济特区和唯一的省级经济特区，海南岛是仅次于台湾岛的中国第二大岛。海南省北以琼州海峡与广东省划界，西临北部湾与广西壮族自治区和越南相对，东濒南海与台湾省对望，东南和南边在南海中与菲律宾、文莱和马来西亚为邻。1988年4月，海南建省、成立海南经济特区。海南省行政区域包括海南岛和西沙群岛、南沙群岛、中沙群岛的岛礁及其海域。海南地处热带北缘，属热带季风气候。2018年4月13日，党中央决定支持海南全岛建设自由贸易试验区。2018年6月3日，经海南省委、省政府深入调研、统筹规划，决定设立海口江东新区，将其作为建设中国（海南）自由贸易试验区的重点先行区域";
                    Intent intent=new Intent(MainActivity.this,DealAdapter.class);
                    intent.putExtra("country",b);
                    intent.putExtra("introduce",c);
                    startActivity(intent);
                }
                else if(pArea.name.equals("四川省")){
                    b=new int[]{R.mipmap.sichuan1,R.mipmap.sichuan2,R.mipmap.sichuan3,R.mipmap.sichuan4,R.mipmap.sichuan5};
                    c="四川，简称\"川\"或\"蜀\"，省会成都，位于中国大陆西南腹地，自古就有\"天府之国\"之美誉，是中国西部门户，大熊猫故乡。四川今与重庆、贵州、云南、西藏、青海、甘肃、陕西诸省市交界。四川东部为川东平行岭谷和川中丘陵，中部为成都平原，西部为川西高原。四川是中国重要的经济、工业、农业、军事、旅游、文化大省。省会成都在1993年被国务院确定为中国西南地区的科技、商贸、金融中心和交通、通信枢纽。成都双流国际机场是中国第四大航空港。四川省是一个多民族的大家庭，境内有中国第二大藏区（甘孜州、阿坝州）、中国最大彝区（凉山州）和中国唯一羌族自治县（北川县），其中甘孜州是康藏文化的核心区。 四川历史悠久，文化灿烂，自然风光绚丽多彩，拥有九寨沟、黄龙、都江堰、青城山、乐山大佛、峨眉山、三星堆、金沙遗址、武侯祠、杜甫草堂、宽窄巷子、阆中古城、海螺沟、四姑娘山、稻城亚丁等享誉海内外的旅游景区";
                    Intent intent=new Intent(MainActivity.this,DealAdapter.class);
                    intent.putExtra("country",b);
                    intent.putExtra("introduce",c);
                    startActivity(intent);
                }
                else if(pArea.name.equals("贵州省")){
                    b=new int[]{R.mipmap.guizhou1,R.mipmap.guizhou2,R.mipmap.guizhou3,R.mipmap.guizhou4,R.mipmap.guizhou5};
                    c="贵州省，简称“黔”或“贵”，地处中国西南腹地，与重庆、四川、湖南、云南、广西接壤，是西南交通枢纽。世界知名山地旅游目的地和山地旅游大省，国家生态文明试验区，内陆开放型经济试验区。辖贵阳市、遵义市、毕节市、安顺市、六盘水市、铜仁市、黔西南布依族苗族自治州、黔东南苗族侗族自治州、黔南布依族苗族自治州。贵州境内地势西高东低，自中部向北、东、南三面倾斜，全省地貌可概括分为：高原、山地、丘陵和盆地四种基本类型，高原山地居多，素有“八山一水一分田”之说，是全国唯一没有平原支撑的省份。属亚热带湿润季风气候，四季分明、春暖风和、雨量充沛、雨热同期。贵州是古人类发祥地之一，远古人类化石和远古文化遗存发现颇多。早在24万年前，就有人类栖息繁衍，已发现石器时代文化遗址80余处。观音洞旧石器遗址被正式命名为“观音洞文化”，对研究中国旧石器时代的起源和发展具有重要的科学价值";
                    Intent intent=new Intent(MainActivity.this,DealAdapter.class);
                    intent.putExtra("country",b);
                    intent.putExtra("introduce",c);
                    startActivity(intent);
                }
                else if(pArea.name.equals("云南省")){
                    b=new int[]{R.mipmap.yunnan1,R.mipmap.yunnan2,R.mipmap.yunnan3,R.mipmap.yunnan4,R.mipmap.yunnan5};
                    c="云南，简称云（滇），省会昆明，位于中国西南的边陲，是人类文明重要发祥地之一。生活在距今170万年前的云南元谋人，是截至2013年为止发现的中国和亚洲最早人类。战国时期，这里是滇族部落的生息之地。云南即“彩云之南”“七彩云南”，另一说法是因位于“云岭之南”而得名。面积39万平方千米，占全国面积4.11%，在全国各省级行政区中面积排名第8。总人口4596万（2010年），占全国人口3.35%，人口排名为第12名。下辖8个市、8个少数民族自治州。 与云南省相邻的省区有四川、贵州、广西、西藏。云南3个邻国是缅甸、老挝和越南。北回归线从该省南部横穿而过。云南历史文化悠久，自然风光绚丽，拥有丽江古城、三江并流、石林、哈尼梯田、大理古城、崇圣寺三塔、玉龙雪山、洱海、滇池、抚仙湖、梅里雪山、普达措国家公园、噶丹松赞林寺、西双版纳热带雨林等旅游景点";
                    Intent intent=new Intent(MainActivity.this,DealAdapter.class);
                    intent.putExtra("country",b);
                    intent.putExtra("introduce",c);
                    startActivity(intent);
                }
                else if(pArea.name.equals("陕西省")){
                    b=new int[]{R.mipmap.shanxi1,R.mipmap.shanxi2,R.mipmap.shanxi3,R.mipmap.shanxi4,R.mipmap.shanxi5};
                   c="陕西（Shaanxi Province），简称“陕”或“秦”，中华人民共和国省级行政单位之一，省会古都西安。地理位置介于东经105°29′~111°15′，北纬31°42′～39°35′之间，自然区划上因秦岭-淮河一线而横跨北方与南方。位于西北内陆腹地，横跨黄河和长江两大流域中部，连接中国东、中部地区和西北、西南的重要枢纽。 陕西是中国经纬度基准点大地原点和北京时间中国科学院国家授时中心所在地。全省总面积20.58万平方公里，2014年末常驻人口3775万，下辖1个副省级城市、9个地级市，其中西安、宝鸡两市城市人口过百万。 陕西历史悠久，是中华文明的重要发祥地之一，上古时为雍州、梁州所在，是炎帝故里及黄帝的葬地。西周初年，周成王以陕原为界，原西由召公管辖，后人遂称陕原以西为“陕西”。陕西自古是帝王建都之地，九个大一统王朝，有五个建都西安（咸阳），留下的帝王陵墓共79座，被称为“东方金字塔”。 陕西是中国重要科教高地之一，拥有西安交通大学、西北工业大学、西安电子科技大学等8所985或211工程类大学 。陕西有三项九处世界遗产，分别是：长城、秦始皇兵马俑、大雁塔、小雁塔、兴教寺塔、大明宫、未央宫、彬县大佛寺石窟、张骞墓";
                    Intent intent=new Intent(MainActivity.this,DealAdapter.class);
                    intent.putExtra("country",b);
                    intent.putExtra("introduce",c);
                    startActivity(intent);
                }
                else if(pArea.name.equals("甘肃省")){
                    b=new int[]{R.mipmap.gansu1,R.mipmap.gansu2,R.mipmap.gansu3,R.mipmap.gansu4,R.mipmap.gansu5};
                    c="甘肃省，简称甘或陇，中国省级行政单位之一，位于黄河上游，省会为兰州市。甘肃是取甘州（今张掖）与肃州（今酒泉）二地的首字而成，由于西夏曾置甘肃军司，元代设甘肃省，简称甘；又因省境大部分在陇山（六盘山）以西，而唐代曾在此设置过陇右道，故又简称为陇。 甘肃地处北纬32°31′～42°57′，东经92°13′～108°46′，地控黄河上游，沟通黄土高原、青藏高原、内蒙古高原，东通陕西，南瞰巴蜀、青海，西达新疆，北扼内蒙古、宁夏；西北出蒙古国，辐射中亚。甘肃省东西蜿蜒1600多公里，全省面积45.37万平方公里，占中国4.72%。全省总人口为2763.65万人，常住人口2553.9万人。辖12个地级市、2个自治州。 甘肃历史跨越八千余年，是中华民族和华夏文明的重要发祥地之一，也是中医药学的发祥地之一，被誉为“河岳根源、羲轩桑梓”。中华民族的人文始祖伏羲、女娲和黄帝相传诞生在甘肃。西王母降凡于泾川县回中山。周人崛起于庆阳，秦人肇基于天水、陇南。天下李氏的根在陇西。 2014年，甘肃省GDP达6835.27亿元亿元。经过建国以来的开发建设，甘肃已形成了以石油化工、有色冶金、机械电子等为主的工业体系，成为中国重要的能源、原材料工业基地";
                    Intent intent=new Intent(MainActivity.this,DealAdapter.class);
                    intent.putExtra("country",b);
                    intent.putExtra("introduce",c);
                    startActivity(intent);
                }
                else if(pArea.name.equals("青海省")){
                    b=new int[]{R.mipmap.qinghai1,R.mipmap.qinghai2,R.mipmap.qinghai3,R.mipmap.qinghai4,R.mipmap.qinghai5};
                    c="青海为位于中国西部，雄踞世界屋脊青藏高原的东北部 。是中国青藏高原上的重要省份之一，简称青，省会为西宁。据全国第二次土地调查公报显示，青海省东西长约1200公里，南北宽800公里，面积为72.10万平方公里 。 境内山脉高耸，地形多样，河流纵横，湖泊棋布。昆仑山横贯中部，唐古拉山峙立于南，祁连山矗立于北，茫茫草原起伏绵延，柴达木盆地浩瀚无限。长江、黄河之源头在青海，中国最大的内陆高原咸水湖也在青海，因此而得名“青海”。青海与甘肃、四川、西藏、新疆接壤，辖西宁市、海东市两个地级市和玉树藏族自治州、海西州、海北州、海南州、黄南州、果洛州等6个民族自治州，共48县级行政单位。青海省有藏族、回族、蒙古族、土族、撒拉族等43个少数民族，全省常住人口593.46万（2016年）。 青海有着“世界屋脊”的美称。青海东部素有“天河锁钥”、“海藏咽喉”、“金城屏障”、“西域之冲”和“玉塞咽喉”等称谓，是长江、黄河、澜沧江的发源地，被誉为“三江源”、“江河源头”、“中华水塔”。青海省地处青藏高原东北部，青海的地形大势是盆地、高山和河谷相间分布的高原。它是“世界屋脊”青藏高原的一部分";
                    Intent intent=new Intent(MainActivity.this,DealAdapter.class);
                    intent.putExtra("country",b);
                    intent.putExtra("introduce",c);
                    startActivity(intent);
                }
                else if(pArea.name.equals("西藏自治区")){
                    b=new int[]{R.mipmap.xizang1,R.mipmap.xizang2,R.mipmap.xizang3,R.mipmap.xizang4,R.mipmap.xizang5};
                    c="西藏自治区，古称“蕃”，简称“藏”，首府拉萨，是中国五个少数民族自治区之一。位于中国青藏高原西南部，地处北纬26°50′至36°53′，东经78°25′至99°06′之间。北邻新疆维吾尔自治区，东连四川省，东北紧靠青海省，东南连接云南省，南与缅甸、印度、不丹、尼泊尔等国家毗邻，西与克什米尔地区接壤，陆地国界线4000多公里，南北最宽900多公里，东西最长达2000多公里，是中国西南边陲的重要门户，无出海口。 全区面积120.223万平方公里，约占全国总面积的1/8，在全国各省、市、自治区中仅次于新疆。平均海拔在4000米以上，素有“世界屋脊”之称。2012年末全区常住人口总数为308万人， 辖4个地级市、3个地区，4个市辖区、72个县。 藏族人民是中华民族大家庭中的重要一员。西藏唐宋时期称为“吐蕃”，元明时期称为“乌斯藏”，清代称为“唐古特”、“图伯特”等。清朝康熙年间起称“西藏”至今。西藏以其雄伟壮观、神奇瑰丽的自然风光闻名。它地域辽阔，地貌壮观、资源丰富。自古以来，这片土地上的人们创造了丰富灿烂的民族文化";
                    Intent intent=new Intent(MainActivity.this,DealAdapter.class);
                    intent.putExtra("country",b);
                    intent.putExtra("introduce",c);
                    startActivity(intent);
                }
                else if(pArea.name.equals("内蒙古自治区")){
                    b=new int[]{R.mipmap.neimenggu1,R.mipmap.neimenggu2,R.mipmap.neimenggu3,R.mipmap.neimenggu4,R.mipmap.neimenggu5};
                    c="内蒙古自治区，位于中华人民共和国北部边疆，首府呼和浩特，横跨东北、华北、西北地区，接邻八个省区，是中国邻省最多的省级行政区之一，北与蒙古国和俄罗斯联邦接壤。是中国五个少数民族自治区之一。 内蒙古自治区地处欧亚大陆内部，东西直线距离2400公里，南北跨度1700公里，土地国境线长4200公里。内蒙古全区面积为118.3万平方公里，占全国总面积的12.3%，2014年末，全区常住人口为2504.8万人，主要分布有汉族、蒙古族，以及满、回、达斡尔、鄂温克等49个民族，民族众多。辖9个地级市、3盟，共计22个市辖区、11个县级市、17个县、49旗、自治旗。内蒙古资源储量丰富，有“东林西矿、南农北牧”之称，草原、森林和人均耕地面积居全中国第一，稀土金属储量居世界首位，同时也是中国最大的草原牧区。 内蒙古是中国经济发展最快的省市区之一。2005年全自治区GDP比2000年翻了一番多，人均GDP超过中国大陆平均水平。边境口岸众多，与京津冀、东北、西北经济技术合作关系密切，是京津冀协同发展辐射区。2017年是内蒙古自治区成立70周年";
                    Intent intent=new Intent(MainActivity.this,DealAdapter.class);
                    intent.putExtra("country",b);
                    intent.putExtra("introduce",c);
                    startActivity(intent);
                }
                else if(pArea.name.equals("宁夏自治区")){
                    b=new int[]{R.mipmap.ningxia1,R.mipmap.ningxia2,R.mipmap.ningxia3,R.mipmap.ningxia4,R.mipmap.ningxia5};
                    c="宁夏回族自治区，简称宁，是中国五大自治区之一。处在中国西部的黄河上游地区，东邻陕西省，西部、北部接内蒙古自治区，南部与甘肃省相连。南北相距约456公里，东西相距约250公里，总面积为6.6万多平方千米。自治区首府银川。宁夏是中华文明的发祥地之一，位于\"丝绸之路\"上，历史上曾是东西部交通贸易的重要通道，作为黄河流经的地区，这里同样有古老悠久的黄河文明。早在三万年前，宁夏就已有了人类生息的痕迹，公元1038年，党项族的首领李元昊在此建立了西夏王朝，并形成了西夏文化。古今素有\"塞上江南\"之美誉";
                    Intent intent=new Intent(MainActivity.this,DealAdapter.class);
                    intent.putExtra("country",b);
                    intent.putExtra("introduce",c);
                    startActivity(intent);
                }
                else if(pArea.name.equals("广西自治区")){
                    b=new int[]{R.mipmap.guangxi1,R.mipmap.guangxi2,R.mipmap.guangxi3,R.mipmap.guangxi4,R.mipmap.guangxi5};
                    c="广西壮族自治区，因广西大部分地区属于秦统一岭南设置桂林郡而简称桂，首府南宁市，下辖有14个地级市，8个县级市（地级市代管），是中国五个少数民族自治区之一，是中国唯一一个沿海自治区。位于中国华南地区西部，从东至西分别与广东、湖南、贵州、云南接壤，南濒北部湾、面向东南亚，西南与越南毗邻，是西南地区最便捷的出海通道，在中国与东南亚的经济交往中占有重要地位。 广西是中国—东盟博览会的举办地。区内聚居着以汉、壮、瑶、苗、侗、京、回等民族，汉语方言有粤语、西南官话（桂柳话）、客家语、平话、湘语、闽语六种，壮语方言有北部方言和南部方言，其他少数民族语言有苗语、瑶语等。 广西的大陆海岸线长约1595千米，区内交通便利。奇特的喀斯特地貌，灿烂的文物古迹，浓郁的民族风情，使广西独具魅力。 广西属亚热带季风气候区，孕育了大量珍贵的动植物资源。尤其盛产水果，被誉为“水果之乡”，主要品种有火龙果、番石榴、荔枝、金桔、蜜橘、龙眼";
                    Intent intent=new Intent(MainActivity.this,DealAdapter.class);
                    intent.putExtra("country",b);
                    intent.putExtra("introduce",c);
                    startActivity(intent);
                }
                else if(pArea.name.equals("新疆自治区")){
                    b=new int[]{R.mipmap.xinjiang1,R.mipmap.xinjiang2,R.mipmap.xinjiang3,R.mipmap.xinjiang4,R.mipmap.xinjiang5};
                    c="新疆维吾尔自治区，简称新疆，位于中国西北边陲，首府乌鲁木齐，是中国五个少数民族自治区之一，也是中国陆地面积最大的省级行政区，面积166万平方公里，占中国国土总面积六分之一。 新疆地处亚欧大陆腹地，陆地边境线5600多公里，周边与俄罗斯、哈萨克斯坦、吉尔吉斯斯坦、塔吉克斯坦、巴基斯坦、蒙古、印度、阿富汗斯坦八国接壤，在历史上是古丝绸之路的重要通道，现在是第二座“亚欧大陆桥”的必经之地，战略位置十分重要。新疆现有47个民族成分，主要居住有维吾尔、汉、哈萨克、回、蒙古、柯尔克孜、锡伯、塔吉克、乌兹别克、满、达斡尔、塔塔尔、俄罗斯等民族，是中国五个少数民族自治区之一。新疆自汉朝以来就是中国不可分割的一部分，是中国神圣领土的一部分。公元前60年，西汉中央政权设立西域都护府，新疆正式成为中国领土的一部分。1884年清政府在新疆设省。1949年新疆和平解放。1955年10月1日成立新疆自治区，新疆现有14个地、州、市，89个县（市），其中33个为边境县（市）";
                    Intent intent=new Intent(MainActivity.this,DealAdapter.class);
                    intent.putExtra("country",b);
                    intent.putExtra("introduce",c);
                    startActivity(intent);
                }
                else if(pArea.name.equals("台湾")){
                    b=new int[]{R.mipmap.taiwan1,R.mipmap.taiwan2,R.mipmap.taiwan3,R.mipmap.taiwan4,R.mipmap.taiwan5};
                    c="台湾（Taiwan）位于中国大陆东南沿海的大陆架上，东临太平洋， 东北邻琉球群岛， 南界巴士海峡与菲律宾群岛相对，西隔台湾海峡与福建省相望，总面积约3.6万平方千米，包括台湾岛及兰屿、绿岛、钓鱼岛等21个附属岛屿和澎湖列岛64个岛屿。台湾岛面积35882.6258平方千米，是中国第一大岛，7成为山地与丘陵，平原主要集中于西部沿海，地形海拔变化大。由于地处热带及亚热带气候之交界，自然景观与生态资源丰富多元。原住民族（高山族）在17世纪汉族移入前即已在此定居；自明末清初始有较显著之福建南部和广东东部人民移垦，最终形成以汉族为主体的社会。南宋澎湖属福建路；元、明在澎湖设巡检司；明末被荷兰和西班牙侵占； 1662年郑成功收复；清代1684年置台湾府，属福建省，1885年建省； 1895年清政府以《马关条约》割让与日本； 1945年抗战胜利后光复；1949年国民党政府在内战失利中退守台湾，海峡两岸分治至今。 台湾自1960年代起推行出口导向型工业化战略，经济社会发展突飞猛进，缔造了举世瞩目的台湾经济奇迹， 名列亚洲四小龙之一，于1990年代跻身发达经济体之列。台湾制造业与高新技术产业发达，半导体、IT、通讯、电子精密制造等领域全球领先。台湾文化以中华文化为主体，是中华文化的重要组成部分，原住民族的南岛文化亦有影响， 近现代又融合日本和欧美文化，呈现多元风貌";
                    Intent intent=new Intent(MainActivity.this,DealAdapter.class);
                    intent.putExtra("country",b);
                    intent.putExtra("introduce",c);
                    startActivity(intent);
                }

            }
        });
        screenWidth = ScreenUtils.getScreenWidth(this);
        scale = screenWidth / mapWidth;
   

        scaleScrollView.postDelayed(new Runnable() {
            @Override
            public void run() {
                scaleAndScroll();

            }
        },800);

    }

    private void scaleAndScroll() {
        rlMap.setScaleX(scale);
        rlMap.setScaleY(scale);
        scaleScrollView.smoothScrollTo((rlMap.getWidth() - screenWidth) / 2, (int) (rlMap.getHeight() - (scale * mapWidth)) / 2-200);
    }
}
