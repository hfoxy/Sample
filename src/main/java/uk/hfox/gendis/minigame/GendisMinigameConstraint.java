package uk.hfox.gendis.minigame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GendisMinigameConstraint extends GendisMinigameBasic {

    private final String key;
    private final int index;

    private final boolean multiple;
    private final List<GendisConstraint> constraints;

    public GendisMinigameConstraint(String key, int index, boolean multiple, List<GendisConstraint> constraints) {
        this.key = key;
        this.index = index;
        this.multiple = multiple;
        this.constraints = new ArrayList<>(constraints);
    }

    public GendisMinigameConstraint(String key, int index, boolean multiple, GendisConstraint... constraints) {
        this.key = key;
        this.index = index;
        this.multiple = multiple;
        this.constraints = new ArrayList<>();
        Collections.addAll(this.constraints, constraints);
    }

    @Override
    public String getKey() {
        return key;
    }

    @Override
    public int getIndex() {
        return index;
    }

    @Override
    public boolean hasResponse(int input) {
        for (GendisConstraint constraint : this.constraints) {
            if (constraint.isSatisfied(input)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public String getResponse(int input) {
        boolean satisfied = false;
        StringBuilder builder = new StringBuilder();
        for (GendisConstraint constraint : this.constraints) {
            if (constraint.isSatisfied(input)) {
                satisfied = true;
                builder.append(constraint.getResponse());

                if (!multiple) {
                    break;
                }
            }
        }

        if (!satisfied) {
            throw new IllegalArgumentException("input is not supported");
        }

        return builder.toString();
    }

}
