package am.barcamp.official;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.StrictMode;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.recyclerview.extensions.ListAdapter;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import am.barcamp.official.adapter.WorkshopAdapter;
import am.barcamp.official.dto.ScheduleItem;
import am.barcamp.official.networking.NetworkClient;
import am.barcamp.official.networking.ScheduleService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class ExploreWorkshopsActivity extends AppCompatActivity {

    private List<ScheduleItem> result = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browse_workshops);

        RecyclerView rvWorkshop = findViewById(R.id.ourview);
        rvWorkshop.setLayoutManager(new LinearLayoutManager(this));


        Retrofit retrofit = NetworkClient.getRetrofitClient();

        ScheduleService scheduleService = retrofit.create(ScheduleService.class);

        Call<List<ScheduleItem>> call = scheduleService.getSchedule();

        call.enqueue(new Callback<List<ScheduleItem>>() {
            @TargetApi(Build.VERSION_CODES.N)
            @Override
            public void onResponse(Call<List<ScheduleItem>> call, Response<List<ScheduleItem>> response) {
                if (response.body() != null) {
                    List<ScheduleItem> scheduleResponse = response.body();
                    result.addAll(scheduleResponse);
                    WorkshopAdapter adapter = new WorkshopAdapter(result);
                    rvWorkshop.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<List<ScheduleItem>> call, Throwable t) {

            }
        });
    }
}
