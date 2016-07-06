package ctci.chap8;


import java.util.HashMap;
import java.util.Map;

public class JigsawPuzzle {
    public enum Side {
        North, South, East, West;

        static Side getMatchingSide(Side side) {
            switch (side) {
                case North:
                    return South;
                case South:
                    return North;
                case East:
                    return West;
                case West:
                    return East;
            }
            throw new UnsupportedOperationException();
        }
    }

    public enum EdgeType {
        Flat, In, Out;
    }

    static class Edge {
        private EdgeType edgeType;

        public Edge(EdgeType edgeType) {
            this.edgeType = edgeType;
        }

        public EdgeType getEdgeType() {
            return edgeType;
        }
    }

    static class JigsawPiece {

        private Map<Side, Edge> edges = new HashMap<>();

        public JigsawPiece(Map<Side, Edge> edges) {
            this.edges = edges;
        }

        public Edge getEdge(Side side) {
            return edges.get(side);
        }

        public boolean fitsWith(Side thisSide, JigsawPiece piece, Side thatSide) {
            Edge thisEdge = edges.get(thisSide);
            Edge thatEdge = piece.getEdge(thatSide);
            return Side.getMatchingSide(thisSide) == thatSide &&
                    (
                            (thisEdge.getEdgeType() == EdgeType.In && thatEdge.getEdgeType() == EdgeType.Out) ||
                                    (thisEdge.getEdgeType() == EdgeType.Out && thatEdge.getEdgeType() == EdgeType.In)
                    );
        }
    }


}
