package com.zrdh.utils;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.http.util.TextUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Map;
import java.util.Set;

/**
 * Description: cti-link-dataAnalysis
 * Created by hua on 2020/3/25 11:13
 */
public class HttpClientUtil {
    public static String sendPost(String url, JSONObject obj) throws Exception{
        HttpPost httpPost = new HttpPost(url);

        RequestConfig requestConfig = RequestConfig.custom()
                .setSocketTimeout(300 * 1000)
                .setConnectTimeout(300 * 1000)
                .build();

        httpPost.setHeader("Content-Type", "application/json;charset=UTF-8");

        StringEntity se = new StringEntity(obj.toString(), Charset.forName("UTF-8"));
        se.setContentType("text/json");

        httpPost.setEntity(se);
        CloseableHttpClient httpClient = null;
        CloseableHttpResponse response = null;
        HttpEntity entity = null;
        String responseContent = null;
        try {
            // 创建默认的httpClient实例.
            httpClient = HttpClients.createDefault();

            httpPost.setConfig(requestConfig);
            // 执行请求
            response = httpClient.execute(httpPost);

            entity = response.getEntity();

            responseContent = EntityUtils.toString(entity, "UTF-8");
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                // 关闭连接,释放资源
                if (response != null) {
                    response.close();
                }
                if (httpClient != null) {
                    httpClient.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return responseContent;
    }

    public static String httpGet(String url, Map<String,Object> map) {
        //url的拼接操作url+"?key=value&"
        try {
            //调用一个自定义的解析参数map获取username和password的方法
            String data = parsePamars(map);
            String strurl = url + "?" + data;
            URL newUrl = new URL(strurl);
            HttpURLConnection conn = (HttpURLConnection) newUrl.openConnection();//打开连接
            conn.setRequestMethod("GET");//设置请求方式，大写的GET
            //调用自定义获取请求结果的封装方法
            String result = readRusult(conn);
            return result;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String parsePamars(Map<String ,Object> map) {
        String data = "";
        if (!map.isEmpty()) {
            Set<String> set = map.keySet();//遍历map中的健，找到对应的值
            for (String key : set) {
                String value = map.get(key).toString();//取得值
                data = data + key + "=" + value + "&";//最后会多出一个&符号

            }
            if (!TextUtils.isEmpty(data)) {
                data = data.substring(0, data.length() - 1);//将最后一个&符号去掉
            }
        }
        return data;
    }

    public static String readRusult(HttpURLConnection conn){
        try {
            int code= conn.getResponseCode();
            if(code==200){//请求成功,读取结果
                InputStream is=conn.getInputStream();
                InputStreamReader inreader=new InputStreamReader(is);
                BufferedReader reader=new BufferedReader(inreader);
                String line="";
                StringBuffer buffer=new StringBuffer();
                while ((line=reader.readLine())!=null){
                    buffer.append(line);
                }
                //关闭流，断开连接
                reader.close();
                inreader.close();
                is.close();
                conn.disconnect();
                return buffer.toString();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
