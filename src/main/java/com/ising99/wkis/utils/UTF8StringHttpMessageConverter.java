package com.ising99.wkis.utils;

import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.util.FileCopyUtils;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jerry on 2014/7/28.
 */
public class UTF8StringHttpMessageConverter extends AbstractHttpMessageConverter<String> {
    public static final Charset DEFAULT_CHARSET = Charset.forName("UTF-8");
    private final List<Charset> availableCharsets;

    public UTF8StringHttpMessageConverter() {
        this(DEFAULT_CHARSET);
    }

    public UTF8StringHttpMessageConverter(Charset defaultCharset) {
        super(new MediaType("application", "json", defaultCharset), MediaType.ALL);
        this.availableCharsets = new ArrayList<Charset>(Charset.availableCharsets().values());
    }

    @Override
    protected boolean supports(Class<?> clazz) {
        return String.class.equals(clazz);
    }

    @Override
    protected String readInternal(Class<? extends String> clazz, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
        MediaType contentType = inputMessage.getHeaders().getContentType();
        Charset charset = contentType.getCharSet() != null ? contentType.getCharSet() : DEFAULT_CHARSET;
        return FileCopyUtils.copyToString(new InputStreamReader(inputMessage.getBody(), charset));
    }

    @Override
    protected void writeInternal(String t, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
        MediaType contentType = outputMessage.getHeaders().getContentType();
        Charset charset = contentType.getCharSet() != null ? contentType.getCharSet() : DEFAULT_CHARSET;
        outputMessage.getHeaders().set("Cache-Control", "no-cache");
        //UTF-8 编码
        outputMessage.getHeaders().set("Content-Type", "text/html; charset=utf-8");
        outputMessage.getHeaders().set("Content-Type", "text/json; charset=utf-8");
        FileCopyUtils.copy(t, new OutputStreamWriter(outputMessage.getBody(), charset));
    }

    protected List<Charset> getAcceptedCharsets() {
        return this.availableCharsets;
    }

    @Override
    protected Long getContentLength(String s, MediaType contentType) {
        if (contentType != null && contentType.getCharSet() != null) {
            Charset charset = contentType.getCharSet();
            try {
                return (long) s.getBytes(charset.name()).length;
            } catch (UnsupportedEncodingException ex) {
                throw new InternalError(ex.getMessage());
            }
        } else {
            return null;
        }
    }
}
