package Model.Dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigInteger;

@ToString
public class BroadcastStationDto
{
    @Getter @Setter
    private String nameBroadcastStation;

    @Getter @Setter
    private String formatBroadcastStation;

    @Getter @Setter
    private String genderBroadcastStation;

    @Getter @Setter
    private BigInteger signalBroadcastStation;
}
