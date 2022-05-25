package Model.Dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@ToString
public class MusicalTrackDto implements Serializable
{
    @Getter @Setter
    private String genderMusicalTrack;

    @Getter @Setter
    private String nameMusicalTrack;

    @Getter @Setter
    private String authorMusicalTrack;

    @Getter @Setter
    private String albumMusicalTrack;

    @Getter @Setter
    private String yearMusicalTrack;

    @Getter @Setter
    private String fileMusicalTrack;

    @Override
    public String toString()
    {
    return "Nombre: "+nameMusicalTrack+", autor:"+authorMusicalTrack+", anio: "+yearMusicalTrack;
    }
}
