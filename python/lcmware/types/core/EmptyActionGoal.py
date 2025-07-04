"""LCM type definitions
This file automatically generated by lcm.
DO NOT MODIFY BY HAND!!!!
"""


from io import BytesIO
import struct

import core

class EmptyActionGoal(object):
    """
    ========================================
    Action Types
    ========================================
    Empty action (for testing/ping)
    """

    __slots__ = ["header"]

    __typenames__ = ["core.Header"]

    __dimensions__ = [None]

    def __init__(self):
        self.header = core.Header()
        """ LCM Type: core.Header """

    def encode(self):
        buf = BytesIO()
        buf.write(EmptyActionGoal._get_packed_fingerprint())
        self._encode_one(buf)
        return buf.getvalue()

    def _encode_one(self, buf):
        assert self.header._get_packed_fingerprint() == core.Header._get_packed_fingerprint()
        self.header._encode_one(buf)

    @staticmethod
    def decode(data: bytes):
        if hasattr(data, 'read'):
            buf = data
        else:
            buf = BytesIO(data)
        if buf.read(8) != EmptyActionGoal._get_packed_fingerprint():
            raise ValueError("Decode error")
        return EmptyActionGoal._decode_one(buf)

    @staticmethod
    def _decode_one(buf):
        self = EmptyActionGoal()
        self.header = core.Header._decode_one(buf)
        return self

    @staticmethod
    def _get_hash_recursive(parents):
        if EmptyActionGoal in parents: return 0
        newparents = parents + [EmptyActionGoal]
        tmphash = (0x668656188ce1ef0+ core.Header._get_hash_recursive(newparents)) & 0xffffffffffffffff
        tmphash  = (((tmphash<<1)&0xffffffffffffffff) + (tmphash>>63)) & 0xffffffffffffffff
        return tmphash
    _packed_fingerprint = None

    @staticmethod
    def _get_packed_fingerprint():
        if EmptyActionGoal._packed_fingerprint is None:
            EmptyActionGoal._packed_fingerprint = struct.pack(">Q", EmptyActionGoal._get_hash_recursive([]))
        return EmptyActionGoal._packed_fingerprint

    def get_hash(self):
        """Get the LCM hash of the struct"""
        return struct.unpack(">Q", EmptyActionGoal._get_packed_fingerprint())[0]

