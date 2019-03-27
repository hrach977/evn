package am.barcamp.official.networking;

import java.util.List;

import am.barcamp.official.dto.ScheduleItem;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ScheduleService {

    @GET("/schedule")
    Call<List<ScheduleItem>> getSchedule();
}
