// ------------------------------------------------------------------------------
// Copyright (c) 2015 Microsoft Corporation
// 
// Permission is hereby granted, free of charge, to any person obtaining a copy
// of this software and associated documentation files (the "Software"), to deal
// in the Software without restriction, including without limitation the rights
// to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
// copies of the Software, and to permit persons to whom the Software is
// furnished to do so, subject to the following conditions:
// 
// The above copyright notice and this permission notice shall be included in
// all copies or substantial portions of the Software.
// 
// THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
// IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
// FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
// AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
// LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
// OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
// THE SOFTWARE.
// ------------------------------------------------------------------------------

package com.onedrive.sdk.generated;

import com.onedrive.sdk.concurrency.*;
import com.onedrive.sdk.core.*;
import com.onedrive.sdk.extensions.*;
import com.onedrive.sdk.http.*;
import com.onedrive.sdk.generated.*;
import com.onedrive.sdk.options.*;
import com.onedrive.sdk.serializer.*;

import java.util.*;

// **NOTE** This file was generated by a tool and any changes will be overwritten.

/**
 * The class for the Base Thumbnail Request.
 */
public class BaseThumbnailRequest extends BaseRequest implements IBaseThumbnailRequest {

    /**
     * The request for the Thumbnail
     *
     * @param requestUrl The request url
     * @param client The service client
     * @param options The options for this request
     */
    public BaseThumbnailRequest(String requestUrl, IOneDriveClient client, List<Option> options) {
        super(requestUrl, client, options, Thumbnail.class);
    }

    public void get(final ICallback<Thumbnail> callback) {
        send(HttpMethod.GET, callback, null);
    }

    public Thumbnail get() throws ClientException {
       return send(HttpMethod.GET, null);
    }

    public void update(final Thumbnail sourceThumbnail, final ICallback<Thumbnail> callback) {
        send(HttpMethod.PATCH, callback, sourceThumbnail);
    }

    public Thumbnail update(final Thumbnail sourceThumbnail) throws ClientException {
        return send(HttpMethod.PATCH, sourceThumbnail);
    }

    public void delete(final ICallback<Void> callback) {
        send(HttpMethod.DELETE, callback, null);
    }

    public void delete() throws ClientException {
        send(HttpMethod.DELETE, null);
    }

    public void create(final Thumbnail newThumbnail, final ICallback<Thumbnail> callback) {
        send(HttpMethod.POST, callback, newThumbnail);
    }

    public Thumbnail create(final Thumbnail newThumbnail) throws ClientException {
        return send(HttpMethod.POST, newThumbnail);
    }

    public IThumbnailRequest select(final String value) {
        getQueryOptions().add(new QueryOption("select", value));
        return (ThumbnailRequest)this;
    }

    public IThumbnailRequest top(final int value) {
        getQueryOptions().add(new QueryOption("top", value+""));
        return (ThumbnailRequest)this;
    }

    public IThumbnailRequest expand(final String value) {
        getQueryOptions().add(new QueryOption("expand", value));
        return (ThumbnailRequest)this;
    }
}