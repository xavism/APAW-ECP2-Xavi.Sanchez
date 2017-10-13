package apaw.ecp2.xavi.api.resources;

import java.util.List;

import apaw.ecp2.xavi.api.controllers.VoteController;
import apaw.ecp2.xavi.api.dtos.VoteDto;
import apaw.ecp2.xavi.api.resources.exceptions.ThemeIdNotFoundException;
import apaw.ecp2.xavi.api.resources.exceptions.VoteInvalidException;

public class VoteResource {

    public static final String VOTES = "votes";

    public void createVote(int themeId, int vote) throws VoteInvalidException, ThemeIdNotFoundException {
        if (vote < 0 || vote > 10) {
            throw new VoteInvalidException(Integer.toString(vote));
        }
        if (!new VoteController().createVote(themeId, vote)) {
            throw new ThemeIdNotFoundException(Integer.toString(themeId));
        }
    }

    public List<VoteDto> voteList() {
        return new VoteController().voteList();
    }

}
