package kissz;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class BinaryTreeCodecTest {

    @Test
    public void serializeDeserialize() {
        BinaryTreeCodec codec = new BinaryTreeCodec();
        for (TreeNode t : generateTrees()) {
            assertEquals(t, codec.deserialize(codec.serialize(t)));
        }
    }

    List<TreeNode> generateTrees() {
        return new ArrayList<>();
    }
}