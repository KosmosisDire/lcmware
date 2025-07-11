"""LCM type definitions
This file automatically generated by lcm.
DO NOT MODIFY BY HAND!!!!
"""


from io import BytesIO
import struct

import core

class ByteArrayResponse(object):

    __slots__ = ["response_header", "data_size", "data"]

    __typenames__ = ["core.ResponseHeader", "int32_t", "int8_t"]

    __dimensions__ = [None, None, ["data_size"]]

    def __init__(self):
        self.response_header = core.ResponseHeader()
        """ LCM Type: core.ResponseHeader """
        self.data_size = 0
        """ LCM Type: int32_t """
        self.data = []
        """ LCM Type: int8_t[data_size] """

    def encode(self):
        buf = BytesIO()
        buf.write(ByteArrayResponse._get_packed_fingerprint())
        self._encode_one(buf)
        return buf.getvalue()

    def _encode_one(self, buf):
        assert self.response_header._get_packed_fingerprint() == core.ResponseHeader._get_packed_fingerprint()
        self.response_header._encode_one(buf)
        buf.write(struct.pack(">i", self.data_size))
        buf.write(struct.pack('>%db' % self.data_size, *self.data[:self.data_size]))

    @staticmethod
    def decode(data: bytes):
        if hasattr(data, 'read'):
            buf = data
        else:
            buf = BytesIO(data)
        if buf.read(8) != ByteArrayResponse._get_packed_fingerprint():
            raise ValueError("Decode error")
        return ByteArrayResponse._decode_one(buf)

    @staticmethod
    def _decode_one(buf):
        self = ByteArrayResponse()
        self.response_header = core.ResponseHeader._decode_one(buf)
        self.data_size = struct.unpack(">i", buf.read(4))[0]
        self.data = struct.unpack('>%db' % self.data_size, buf.read(self.data_size))
        return self

    @staticmethod
    def _get_hash_recursive(parents):
        if ByteArrayResponse in parents: return 0
        newparents = parents + [ByteArrayResponse]
        tmphash = (0x36bf250724027bc1+ core.ResponseHeader._get_hash_recursive(newparents)) & 0xffffffffffffffff
        tmphash  = (((tmphash<<1)&0xffffffffffffffff) + (tmphash>>63)) & 0xffffffffffffffff
        return tmphash
    _packed_fingerprint = None

    @staticmethod
    def _get_packed_fingerprint():
        if ByteArrayResponse._packed_fingerprint is None:
            ByteArrayResponse._packed_fingerprint = struct.pack(">Q", ByteArrayResponse._get_hash_recursive([]))
        return ByteArrayResponse._packed_fingerprint

    def get_hash(self):
        """Get the LCM hash of the struct"""
        return struct.unpack(">Q", ByteArrayResponse._get_packed_fingerprint())[0]

