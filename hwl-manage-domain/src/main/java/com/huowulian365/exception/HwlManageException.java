package com.huowulian365.exception;


import com.huowulian365.center.base.exception.BaseException;

/**
 * 异常
 */
public class HwlManageException extends BaseException {

    private static final long serialVersionUID = -6202759931628287239L;

    public HwlManageException(){
        super();
    }

    public HwlManageException(String msg) {
        super(msg);
    }

    public HwlManageException(int errCode, String msg) {
        super(errCode, msg);
    }

    public HwlManageException(String msg, Throwable e) {
        super(msg,e);
    }

    public HwlManageException(int errCode, String msg, Throwable e) {
        super(errCode, msg, e);
    }

}
