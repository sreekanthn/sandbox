import java.util.*;

public class MerkleTree
{

    public MerkleTree(List<String> leafValues)
    {

    }

    static final class Node
    {
        public byte type;
        public byte[] signature;
        public Node right_node;
        public Node left_node;

    }

    public void buildMerkleTree(List<String> sigs) throws Exception
    {
        if (sigs.size() < 2)
            throw new Exception("Invalid number of Signatures, need at least 2 of them");

        int noOfSigs = sigs.size();

        //create a list of nodes with this size
        List<Node> nodes = build

    }


}
