/* LCM type definition class file
 * This file was automatically generated by lcm-gen
 * DO NOT MODIFY BY HAND!!!!
 * lcm-gen 1.5.1
 */

package core;
 
import java.io.*;
import java.util.*;
import lcm.lcm.*;
 
public final class UInt32Msg implements lcm.lcm.LCMEncodable
{
    public core.Header header;

    public int value;

 
    public UInt32Msg()
    {
    }
 
    public static final long LCM_FINGERPRINT;
    public static final long LCM_FINGERPRINT_BASE = 0x48b5fd746eae1c91L;
 
    static {
        LCM_FINGERPRINT = _hashRecursive(new ArrayList<Class<?>>());
    }
 
    public static long _hashRecursive(ArrayList<Class<?>> classes)
    {
        if (classes.contains(core.UInt32Msg.class))
            return 0L;
 
        classes.add(core.UInt32Msg.class);
        long hash = LCM_FINGERPRINT_BASE
             + core.Header._hashRecursive(classes)
            ;
        classes.remove(classes.size() - 1);
        return (hash<<1) + ((hash>>63)&1);
    }
 
    public void encode(DataOutput outs) throws IOException
    {
        outs.writeLong(LCM_FINGERPRINT);
        _encodeRecursive(outs);
    }
 
    public void _encodeRecursive(DataOutput outs) throws IOException
    {
        this.header._encodeRecursive(outs); 
 
        outs.writeInt(this.value); 
 
    }
 
    public UInt32Msg(byte[] data) throws IOException
    {
        this(new LCMDataInputStream(data));
    }
 
    public UInt32Msg(DataInput ins) throws IOException
    {
        if (ins.readLong() != LCM_FINGERPRINT)
            throw new IOException("LCM Decode error: bad fingerprint");
 
        _decodeRecursive(ins);
    }
 
    public static core.UInt32Msg _decodeRecursiveFactory(DataInput ins) throws IOException
    {
        core.UInt32Msg o = new core.UInt32Msg();
        o._decodeRecursive(ins);
        return o;
    }
 
    public void _decodeRecursive(DataInput ins) throws IOException
    {
        this.header = core.Header._decodeRecursiveFactory(ins);
 
        this.value = ins.readInt();
 
    }
 
    public core.UInt32Msg copy()
    {
        core.UInt32Msg outobj = new core.UInt32Msg();
        outobj.header = this.header.copy();
 
        outobj.value = this.value;
 
        return outobj;
    }
 
}

