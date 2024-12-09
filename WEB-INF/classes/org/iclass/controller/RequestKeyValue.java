/*
 * Decompiled with CFR 0.152.
 */
package org.iclass.controller;

public class RequestKeyValue {
    private String url;
    private String method;

    public String getUrl() {
        return this.url;
    }

    public String getMethod() {
        return this.method;
    }

    public RequestKeyValue() {
    }

    public RequestKeyValue(String url, String method) {
        this.url = url;
        this.method = method;
    }

    public String toString() {
        return "RequestKeyValue(url=" + this.getUrl() + ", method=" + this.getMethod() + ")";
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof RequestKeyValue)) {
            return false;
        }
        RequestKeyValue other = (RequestKeyValue)o;
        if (!other.canEqual(this)) {
            return false;
        }
        String this$url = this.getUrl();
        String other$url = other.getUrl();
        if (this$url == null ? other$url != null : !this$url.equals(other$url)) {
            return false;
        }
        String this$method = this.getMethod();
        String other$method = other.getMethod();
        return !(this$method == null ? other$method != null : !this$method.equals(other$method));
    }

    protected boolean canEqual(Object other) {
        return other instanceof RequestKeyValue;
    }

    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        String $url = this.getUrl();
        result = result * 59 + ($url == null ? 43 : $url.hashCode());
        String $method = this.getMethod();
        result = result * 59 + ($method == null ? 43 : $method.hashCode());
        return result;
    }
}
