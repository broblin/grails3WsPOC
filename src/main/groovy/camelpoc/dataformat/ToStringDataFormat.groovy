package camelpoc.dataformat

import org.apache.camel.Exchange
import org.apache.camel.spi.DataFormat

/**
 * Created by broblin on 16/03/17.
 */
class ToStringDataFormat implements DataFormat {

    /**
     * Marshals the object to the given Stream.
     *
     * @param exchange the current exchange
     * @param graph the object to be marshalled
     * @param stream the output stream to write the marshalled result to
     * @throws Exception can be thrown
     */
    @Override
    void marshal(Exchange exchange, Object graph, OutputStream stream) throws Exception {
        String data = exchange.context.typeConverter.mandatoryConvertTo(java.lang.Object,graph).toString()
        stream.write(data.bytes)
    }

    /**
     * Unmarshals the given stream into an object.
     * <p/>
     * <b>Notice:</b> The result is set as body on the exchange OUT message.
     * It is possible to mutate the OUT message provided in the given exchange parameter.
     * For instance adding headers to the OUT message will be preserved.
     * <p/>
     * It's also legal to return the <b>same</b> passed <tt>exchange</tt> as is but also a
     * {@link Message} object as well which will be used as the OUT message of <tt>exchange</tt>.
     *
     * @param exchange the current exchange
     * @param stream the input stream with the object to be unmarshalled
     * @return the unmarshalled object
     * @throws Exception can be thrown
     */
    @Override
    Object unmarshal(Exchange exchange, InputStream stream) throws Exception {
        throw UnsupportedOperationException("pas implémenté")
    }
}
