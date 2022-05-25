package Model.Dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.awt.*;
import java.io.Serializable;
import java.math.BigInteger;

@ToString
public class BroadcastStationDto implements Serializable
{
    @Getter @Setter
    private String nameBroadcastStation;

    @Getter @Setter
    private String formatBroadcastStation;

    @Getter @Setter
    private String genderBroadcastStation;

    @Getter @Setter
    private BigInteger signalBroadcastStation;

    @Getter @Setter
    private String imageBroadcastStation;
}
