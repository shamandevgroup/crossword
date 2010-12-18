package biz.shaman.android.crossword.model;

public final class Address implements Comparable<Address>
{
    public final int row;

    public final int column;

    private Address(int row, int column)
    {
        if (row < 1) throw new IllegalArgumentException();
        if (column < 1) throw new IllegalArgumentException();

        this.row = row;
        this.column = column;
    }

    public int compareTo(Address another)
    {
        if (equals(another)) return 0;

        if (row == another.row)
        {
            return column - another.column;
        }

        return row - another.row;
    }

    @Override
    public String toString()
    {
        return Address.class.getSimpleName() + "[" + column + ", " + row + "]";
    }

    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + column;
        result = prime * result + row;
        return result;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        Address other = (Address) obj;
        if (column != other.column) return false;
        if (row != other.row) return false;
        return true;
    }

    // Static section

    private static final int         MAX_CACHED_ROW    = 16;
    private static final int         MAX_CACHED_COLUMN = 16;
    private static final Address[][] CACHE             = new Address[MAX_CACHED_ROW][MAX_CACHED_COLUMN];

    public static Address valueOf(int row, int column)
    {
        if (row >= 1 && row <= MAX_CACHED_ROW && column >= 1 && column <= MAX_CACHED_COLUMN)
        {
            if (CACHE[row - 1][column - 1] != null)
            {
                return CACHE[row - 1][column - 1];
            }

            CACHE[row - 1][column - 1] = new Address(row, column);
            return CACHE[row - 1][column - 1];
        }

        return new Address(row, column);
    }
}
