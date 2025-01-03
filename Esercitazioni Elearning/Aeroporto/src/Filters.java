public class Filters {
    public static class RowFilter implements Filter {
        private final int row;

        public RowFilter(int row) {
            this.row = row;
        }

        @Override
        public boolean apply(Seat seat) {
            return seat.getNumero() == row;
        }
    }

    public static class PositionFilter implements Filter {
        private final char column;

        public PositionFilter(char column) {
            this.column = column;
        }

        @Override
        public boolean apply(Seat seat) {
            return seat.getPosizione() == column;
        }
    }

    public static class StatusFilter implements Filter {
        private final boolean status;

        public StatusFilter(boolean status) {
            this.status = status;
        }

        @Override
        public boolean apply(Seat seat) {
            return status;
        }
    }
}