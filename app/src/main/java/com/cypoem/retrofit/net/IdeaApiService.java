package com.cypoem.retrofit.net;

import com.cypoem.retrofit.module.LoginResponse;
import com.cypoem.retrofit.module.bean.MeiZi;

import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import lotcom.zhpan.idea.net.BaseService;
import lotcom.zhpan.idea.net.BasicResponse;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.PartMap;
import retrofit2.http.Query;
import retrofit2.http.Streaming;
import retrofit2.http.Url;

/**
 * Created by dell on 2017/4/1.
 */

public interface IdeaApiService {

    @Headers("Cache-Control: public, max-age=100")
    @GET("福利/10/1")
    Observable<BasicResponse<List<MeiZi>>> getMezi();

    /**
     * 登录 appId secret
     *
     * @return
     */
    @FormUrlEncoded
    @POST("sec/v1.1.0/login")
    Observable<LoginResponse> login(@FieldMap Map<String, Object> map);

    /**
     * @param page
     * @param number
     * @return
     */
    @Headers("Cache-Control: public, max-age=100")//设置缓存 缓存时间为100s
    @GET("everySay/selectAll.do")
    Observable<BasicResponse<List<MeiZi>>> lookBack(@Query("page") int page, @Query("rows") int number);


    @POST("upload/uploadFile.do")
    Observable<BasicResponse> uploadFiles(@Part("filename") String description,
                                          @Part("pic\"; filename=\"image1.png") RequestBody imgs1,
                                          @Part("pic\"; filename=\"image2.png") RequestBody imgs2);

    @POST("upload/uploadFile.do")
    Observable<BasicResponse> uploadFiles(@Part("filename") String description, @PartMap() Map<String, RequestBody> maps);

    @Streaming
    @GET//("download.do")
    Observable<ResponseBody> download(@Url String url);//直接使用网址下载
}
