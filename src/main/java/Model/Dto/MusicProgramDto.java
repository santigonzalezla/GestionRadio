package Model.Dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;

public class MusicProgramDto implements Serializable
{
    @Getter @Setter
    private String nameBroadcastProgram;

    @Getter @Setter
    private ArrayList<MusicalTrackDto> tracksMusicProgram;
}
