package Model.Dto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

public class MusicProgramDto
{
    @Getter @Setter
    private ArrayList<MusicalTrackDto> tracksMusicProgram;

    @Getter @Setter
    private String descriptionMusicProgram;
}
