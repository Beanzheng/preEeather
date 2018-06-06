package test;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * ��ȡ�����б�
 * ȫ������Ԥ���ӿڵ���JAVAʾ��
 *     dtype     string    N    �������ݸ�ʽ��json��xml,Ĭ��json    
 *     key        string     Y    �������key    
 * @author silk
 *
 */
public class GetCityList {
    /**
     * ���û�ȡ�����б��ӿ�,������������
     * @return ���ؽӿ�����
     */
    public static String excute(){
        String url="http://v.juhe.cn/weather/citys?key=***a7558b2e0bedaa19673f74a6809ce";//�ӿ�URL
        //PureNetUtil��һ����װ��get��post������ȡ�����������ݵĹ�����
        return Demo1.get(url);//ʹ��get����
    }
    /**
     * ���ýӿڷ������ݺ�,��������,��������������õ���ӦID
     * @param cityName ��������
     * @return ���ض�ӦID
     */
    public static String getIDBycityName(String cityName) {
        String result=excute();//���ؽӿڽ��,�õ�json��ʽ����
        if(result!=null){
            JSONObject obj=JSONObject.fromObject(result);
            result=obj.getString("resultcode");//�õ�����״̬��
            if(result!=null&&result.equals("200")){//200��ʾ�ɹ���������
                result=obj.getString("result");//�õ������б���json��ʽ�ַ�������
                JSONArray arr=JSONArray.fromObject(result);
                for(Object o:arr){//��arr���б���
                    //�������е�һ��json�����ַ������н���
                    obj=JSONObject.fromObject(o.toString());
                    /*��ʱobj�� {"id":"2","province":"����","city":"����","district":"����"}*/
                    //��city���keyΪ�����ж�����ҪѰ�ҵ�������¼
                    result=obj.getString("district");
                    //��ֹ�����������ȫ,������������Ϊ����,������ģ����ѯ
                    if(result.equals(cityName)||result.contains(cityName)){
                        result=obj.getString("id");//�õ�ID
                        return result;
                    }
                }
            }
        }
        return result;
    }
    public static void main(String[] args) {
        System.out.println(getIDBycityName("���"));
    }
}