package lotcom.zhpan.idea.net;

import retrofit2.Retrofit;

/**
 * Created by zhpan on 2017/4/1.
 */

public class IdeaApi {
    public static <T> T getApiService(Class<T> cls,String baseUrl) {
        Retrofit retrofit = CommonNetService.getRetrofitBuilder(baseUrl).build();
        return retrofit.create(cls);
    }
}
