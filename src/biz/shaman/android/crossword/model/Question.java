package biz.shaman.android.crossword.model;

public final class Question
{
    public final String text;

    public final String answer;

    private Question(String text, String answer)
    {
        if (text == null) throw new NullPointerException();
        if (answer == null) throw new NullPointerException();
        if (text.length() == 0) throw new IllegalArgumentException();
        if (answer.length() == 0) throw new IllegalArgumentException();

        this.text = text;
        this.answer = answer;
    }

    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((answer == null) ? 0 : answer.hashCode());
        result = prime * result + ((text == null) ? 0 : text.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        Question other = (Question) obj;
        if (answer == null)
        {
            if (other.answer != null) return false;
        }
        else if (!answer.equals(other.answer)) return false;
        if (text == null)
        {
            if (other.text != null) return false;
        }
        else if (!text.equals(other.text)) return false;
        return true;
    }

    @Override
    public String toString()
    {
        return Question.class.getSimpleName() + ": " + text + " (" + answer.length() + ")[" + answer + "]";
    }

}
