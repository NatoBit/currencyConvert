import com.google.gson.annotations.SerializedName;

public record Query( @SerializedName("time_last_update_utc") String lastUpdate,
                     @SerializedName("conversion_rate") double conversionRate) {
}
