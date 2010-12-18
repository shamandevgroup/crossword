package biz.shaman.android.crossword.model;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


public final class Legend
{
    private final Map<Direction, Map<Address, Question>> items;

    @SuppressWarnings("serial")
    private Legend(Map<Direction, Map<Address, Question>> items)
    {
        this.items = Collections.unmodifiableMap(new HashMap<Direction, Map<Address, Question>>()
        {
            {
                for (Direction d : Direction.values())
                {
                    put(d, new HashMap<Address, Question>());
                }
            }
        });
    }

    public void add(Direction direction, Address address, Question question) throws CannotLayoutQuestionException
    {
        if (direction == null) throw new NullPointerException();

        items.get(direction).put(address, question);

        // check for layout
    }

    public Map<Address, Question> getByDirection(Direction direction)
    {
        if (direction == null) throw new NullPointerException();

        return items.get(direction);
    }

}
