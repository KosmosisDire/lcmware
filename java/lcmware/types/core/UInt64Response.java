/* LCM type definition class file
 * This file was automatically generated by lcm-gen
 * DO NOT MODIFY BY HAND!!!!
 * lcm-gen 1.5.1
 */

package core;
 
import java.io.*;
import java.util.*;
import lcm.lcm.*;
 
public final class UInt64Response implements lcm.lcm.LCMEncodable
{
    public core.ResponseHeader response_header;

    public long result;

 
    public UInt64Response()
    {
    }
 
    public static final long LCM_FINGERPRINT;
    public static final long LCM_FINGERPRINT_BASE = 0x6ce08879530b5aebL;
 
    static {
        LCM_FINGERPRINT = _hashRecursive(new ArrayList<Class<?>>());
    }
 
    public static long _hashRecursive(ArrayList<Class<?>> classes)
    {
        if (classes.contains(core.UInt64Response.class))
            return 0L;
 
        classes.add(core.UInt64Response.class);
        long hash = LCM_FINGERPRINT_BASE
             + core.ResponseHeader._hashRecursive(classes)
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
        this.response_header._encodeRecursive(outs); 
 
        outs.writeLong(this.result); 
 
    }
 
    public UInt64Response(byte[] data) throws IOException
    {
        this(new LCMDataInputStream(data));
    }
 
    public UInt64Response(DataInput ins) throws IOException
    {
        if (ins.readLong() != LCM_FINGERPRINT)
            throw new IOException("LCM Decode error: bad fingerprint");
 
        _decodeRecursive(ins);
    }
 
    public static core.UInt64Response _decodeRecursiveFactory(DataInput ins) throws IOException
    {
        core.UInt64Response o = new core.UInt64Response();
        o._decodeRecursive(ins);
        return o;
    }
 
    public void _decodeRecursive(DataInput ins) throws IOException
    {
        this.response_header = core.ResponseHeader._decodeRecursiveFactory(ins);
 
        this.result = ins.readLong();
 
    }
 
    public core.UInt64Response copy()
    {
        core.UInt64Response outobj = new core.UInt64Response();
        outobj.response_header = this.response_header.copy();
 
        outobj.result = this.result;
 
        return outobj;
    }
 
}

