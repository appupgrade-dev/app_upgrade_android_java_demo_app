package com.appupgrade.app_upgrade_android_java_demo_app;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface AppUpgradeService {
    @Headers({"Accept: application/json"})
    @GET("api/v1/versions/check")
    Call<AppUpgradeResponse> versionCheck(
            @Header("x-api-key") String x_api_key,
            @Query("app_name") String app_name,
            @Query("app_version") String app_version,
            @Query("platform") String platform,
            @Query("environment") String environment
            );
}
