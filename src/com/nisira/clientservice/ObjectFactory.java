
package com.nisira.clientservice;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.nisira.clientservice package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _ConsultaEstadoCertificadoIdusuario_QNAME = new QName("http://core.sign.nisira.com", "idusuario");
    private final static QName _ConsultaEstadoCertificadoClaveusuario_QNAME = new QName("http://core.sign.nisira.com", "claveusuario");
    private final static QName _ConsultaEstadoCertificadoClaveempresa_QNAME = new QName("http://core.sign.nisira.com", "claveempresa");
    private final static QName _SignServiceExceptionSignServiceException_QNAME = new QName("http://core.sign.nisira.com", "SignServiceException");
    private final static QName _Consulta001ResponseReturn_QNAME = new QName("http://core.sign.nisira.com", "return");
    private final static QName _ExceptionMessage_QNAME = new QName("http://core.sign.nisira.com", "Message");
    private final static QName _Consulta001Var0_QNAME = new QName("http://core.sign.nisira.com", "var0");
    private final static QName _Consulta001Var2_QNAME = new QName("http://core.sign.nisira.com", "var2");
    private final static QName _Consulta001Var3_QNAME = new QName("http://core.sign.nisira.com", "var3");
    private final static QName _ConsultaDocumento_QNAME = new QName("http://core.sign.nisira.com", "documento");
    private final static QName _ConsultaTicket_QNAME = new QName("http://core.sign.nisira.com", "ticket");
    private final static QName _SignAdicional_QNAME = new QName("http://core.sign.nisira.com", "adicional");
    private final static QName _SignXml_QNAME = new QName("http://core.sign.nisira.com", "xml");
    private final static QName _ConsultaIndividualVar4_QNAME = new QName("http://core.sign.nisira.com", "var4");
    private final static QName _ConsultaIndividualVar5_QNAME = new QName("http://core.sign.nisira.com", "var5");
    private final static QName _ConsultaIndividualVar6_QNAME = new QName("http://core.sign.nisira.com", "var6");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.nisira.clientservice
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ConsultaResponse }
     * 
     */
    public ConsultaResponse createConsultaResponse() {
        return new ConsultaResponse();
    }

    /**
     * Create an instance of {@link ConsultaEstadoCertificadoResponse }
     * 
     */
    public ConsultaEstadoCertificadoResponse createConsultaEstadoCertificadoResponse() {
        return new ConsultaEstadoCertificadoResponse();
    }

    /**
     * Create an instance of {@link Consulta001 }
     * 
     */
    public Consulta001 createConsulta001() {
        return new Consulta001();
    }

    /**
     * Create an instance of {@link ConsultaIndividual }
     * 
     */
    public ConsultaIndividual createConsultaIndividual() {
        return new ConsultaIndividual();
    }

    /**
     * Create an instance of {@link Sign }
     * 
     */
    public Sign createSign() {
        return new Sign();
    }

    /**
     * Create an instance of {@link Consulta001Response }
     * 
     */
    public Consulta001Response createConsulta001Response() {
        return new Consulta001Response();
    }

    /**
     * Create an instance of {@link ConsultaEstadoCertificado }
     * 
     */
    public ConsultaEstadoCertificado createConsultaEstadoCertificado() {
        return new ConsultaEstadoCertificado();
    }

    /**
     * Create an instance of {@link Consulta }
     * 
     */
    public Consulta createConsulta() {
        return new Consulta();
    }

    /**
     * Create an instance of {@link SignResponse }
     * 
     */
    public SignResponse createSignResponse() {
        return new SignResponse();
    }

    /**
     * Create an instance of {@link SignServiceException }
     * 
     */
    public SignServiceException createSignServiceException() {
        return new SignServiceException();
    }

    /**
     * Create an instance of {@link Exception }
     * 
     */
    public Exception createException() {
        return new Exception();
    }

    /**
     * Create an instance of {@link ConsultaIndividualResponse }
     * 
     */
    public ConsultaIndividualResponse createConsultaIndividualResponse() {
        return new ConsultaIndividualResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://core.sign.nisira.com", name = "idusuario", scope = ConsultaEstadoCertificado.class)
    public JAXBElement<String> createConsultaEstadoCertificadoIdusuario(String value) {
        return new JAXBElement<String>(_ConsultaEstadoCertificadoIdusuario_QNAME, String.class, ConsultaEstadoCertificado.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://core.sign.nisira.com", name = "claveusuario", scope = ConsultaEstadoCertificado.class)
    public JAXBElement<String> createConsultaEstadoCertificadoClaveusuario(String value) {
        return new JAXBElement<String>(_ConsultaEstadoCertificadoClaveusuario_QNAME, String.class, ConsultaEstadoCertificado.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://core.sign.nisira.com", name = "claveempresa", scope = ConsultaEstadoCertificado.class)
    public JAXBElement<String> createConsultaEstadoCertificadoClaveempresa(String value) {
        return new JAXBElement<String>(_ConsultaEstadoCertificadoClaveempresa_QNAME, String.class, ConsultaEstadoCertificado.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Exception }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://core.sign.nisira.com", name = "SignServiceException", scope = SignServiceException.class)
    public JAXBElement<Exception> createSignServiceExceptionSignServiceException(Exception value) {
        return new JAXBElement<Exception>(_SignServiceExceptionSignServiceException_QNAME, Exception.class, SignServiceException.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://core.sign.nisira.com", name = "return", scope = Consulta001Response.class)
    public JAXBElement<String> createConsulta001ResponseReturn(String value) {
        return new JAXBElement<String>(_Consulta001ResponseReturn_QNAME, String.class, Consulta001Response.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://core.sign.nisira.com", name = "Message", scope = Exception.class)
    public JAXBElement<String> createExceptionMessage(String value) {
        return new JAXBElement<String>(_ExceptionMessage_QNAME, String.class, Exception.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://core.sign.nisira.com", name = "idusuario", scope = Consulta001 .class)
    public JAXBElement<String> createConsulta001Idusuario(String value) {
        return new JAXBElement<String>(_ConsultaEstadoCertificadoIdusuario_QNAME, String.class, Consulta001 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://core.sign.nisira.com", name = "var0", scope = Consulta001 .class)
    public JAXBElement<String> createConsulta001Var0(String value) {
        return new JAXBElement<String>(_Consulta001Var0_QNAME, String.class, Consulta001 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://core.sign.nisira.com", name = "claveusuario", scope = Consulta001 .class)
    public JAXBElement<String> createConsulta001Claveusuario(String value) {
        return new JAXBElement<String>(_ConsultaEstadoCertificadoClaveusuario_QNAME, String.class, Consulta001 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://core.sign.nisira.com", name = "var2", scope = Consulta001 .class)
    public JAXBElement<String> createConsulta001Var2(String value) {
        return new JAXBElement<String>(_Consulta001Var2_QNAME, String.class, Consulta001 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://core.sign.nisira.com", name = "var3", scope = Consulta001 .class)
    public JAXBElement<String> createConsulta001Var3(String value) {
        return new JAXBElement<String>(_Consulta001Var3_QNAME, String.class, Consulta001 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://core.sign.nisira.com", name = "claveempresa", scope = Consulta001 .class)
    public JAXBElement<String> createConsulta001Claveempresa(String value) {
        return new JAXBElement<String>(_ConsultaEstadoCertificadoClaveempresa_QNAME, String.class, Consulta001 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://core.sign.nisira.com", name = "return", scope = ConsultaEstadoCertificadoResponse.class)
    public JAXBElement<String> createConsultaEstadoCertificadoResponseReturn(String value) {
        return new JAXBElement<String>(_Consulta001ResponseReturn_QNAME, String.class, ConsultaEstadoCertificadoResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://core.sign.nisira.com", name = "return", scope = ConsultaIndividualResponse.class)
    public JAXBElement<String> createConsultaIndividualResponseReturn(String value) {
        return new JAXBElement<String>(_Consulta001ResponseReturn_QNAME, String.class, ConsultaIndividualResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://core.sign.nisira.com", name = "return", scope = SignResponse.class)
    public JAXBElement<String> createSignResponseReturn(String value) {
        return new JAXBElement<String>(_Consulta001ResponseReturn_QNAME, String.class, SignResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://core.sign.nisira.com", name = "return", scope = ConsultaResponse.class)
    public JAXBElement<String> createConsultaResponseReturn(String value) {
        return new JAXBElement<String>(_Consulta001ResponseReturn_QNAME, String.class, ConsultaResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://core.sign.nisira.com", name = "idusuario", scope = Consulta.class)
    public JAXBElement<String> createConsultaIdusuario(String value) {
        return new JAXBElement<String>(_ConsultaEstadoCertificadoIdusuario_QNAME, String.class, Consulta.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://core.sign.nisira.com", name = "claveusuario", scope = Consulta.class)
    public JAXBElement<String> createConsultaClaveusuario(String value) {
        return new JAXBElement<String>(_ConsultaEstadoCertificadoClaveusuario_QNAME, String.class, Consulta.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://core.sign.nisira.com", name = "claveempresa", scope = Consulta.class)
    public JAXBElement<String> createConsultaClaveempresa(String value) {
        return new JAXBElement<String>(_ConsultaEstadoCertificadoClaveempresa_QNAME, String.class, Consulta.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://core.sign.nisira.com", name = "documento", scope = Consulta.class)
    public JAXBElement<String> createConsultaDocumento(String value) {
        return new JAXBElement<String>(_ConsultaDocumento_QNAME, String.class, Consulta.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://core.sign.nisira.com", name = "ticket", scope = Consulta.class)
    public JAXBElement<String> createConsultaTicket(String value) {
        return new JAXBElement<String>(_ConsultaTicket_QNAME, String.class, Consulta.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://core.sign.nisira.com", name = "idusuario", scope = Sign.class)
    public JAXBElement<String> createSignIdusuario(String value) {
        return new JAXBElement<String>(_ConsultaEstadoCertificadoIdusuario_QNAME, String.class, Sign.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://core.sign.nisira.com", name = "claveusuario", scope = Sign.class)
    public JAXBElement<String> createSignClaveusuario(String value) {
        return new JAXBElement<String>(_ConsultaEstadoCertificadoClaveusuario_QNAME, String.class, Sign.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://core.sign.nisira.com", name = "claveempresa", scope = Sign.class)
    public JAXBElement<String> createSignClaveempresa(String value) {
        return new JAXBElement<String>(_ConsultaEstadoCertificadoClaveempresa_QNAME, String.class, Sign.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://core.sign.nisira.com", name = "adicional", scope = Sign.class)
    public JAXBElement<String> createSignAdicional(String value) {
        return new JAXBElement<String>(_SignAdicional_QNAME, String.class, Sign.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://core.sign.nisira.com", name = "documento", scope = Sign.class)
    public JAXBElement<String> createSignDocumento(String value) {
        return new JAXBElement<String>(_ConsultaDocumento_QNAME, String.class, Sign.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://core.sign.nisira.com", name = "xml", scope = Sign.class)
    public JAXBElement<String> createSignXml(String value) {
        return new JAXBElement<String>(_SignXml_QNAME, String.class, Sign.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://core.sign.nisira.com", name = "idusuario", scope = ConsultaIndividual.class)
    public JAXBElement<String> createConsultaIndividualIdusuario(String value) {
        return new JAXBElement<String>(_ConsultaEstadoCertificadoIdusuario_QNAME, String.class, ConsultaIndividual.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://core.sign.nisira.com", name = "var0", scope = ConsultaIndividual.class)
    public JAXBElement<String> createConsultaIndividualVar0(String value) {
        return new JAXBElement<String>(_Consulta001Var0_QNAME, String.class, ConsultaIndividual.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://core.sign.nisira.com", name = "claveusuario", scope = ConsultaIndividual.class)
    public JAXBElement<String> createConsultaIndividualClaveusuario(String value) {
        return new JAXBElement<String>(_ConsultaEstadoCertificadoClaveusuario_QNAME, String.class, ConsultaIndividual.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://core.sign.nisira.com", name = "var2", scope = ConsultaIndividual.class)
    public JAXBElement<String> createConsultaIndividualVar2(String value) {
        return new JAXBElement<String>(_Consulta001Var2_QNAME, String.class, ConsultaIndividual.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://core.sign.nisira.com", name = "var3", scope = ConsultaIndividual.class)
    public JAXBElement<String> createConsultaIndividualVar3(String value) {
        return new JAXBElement<String>(_Consulta001Var3_QNAME, String.class, ConsultaIndividual.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://core.sign.nisira.com", name = "claveempresa", scope = ConsultaIndividual.class)
    public JAXBElement<String> createConsultaIndividualClaveempresa(String value) {
        return new JAXBElement<String>(_ConsultaEstadoCertificadoClaveempresa_QNAME, String.class, ConsultaIndividual.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://core.sign.nisira.com", name = "var4", scope = ConsultaIndividual.class)
    public JAXBElement<String> createConsultaIndividualVar4(String value) {
        return new JAXBElement<String>(_ConsultaIndividualVar4_QNAME, String.class, ConsultaIndividual.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://core.sign.nisira.com", name = "var5", scope = ConsultaIndividual.class)
    public JAXBElement<String> createConsultaIndividualVar5(String value) {
        return new JAXBElement<String>(_ConsultaIndividualVar5_QNAME, String.class, ConsultaIndividual.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://core.sign.nisira.com", name = "var6", scope = ConsultaIndividual.class)
    public JAXBElement<String> createConsultaIndividualVar6(String value) {
        return new JAXBElement<String>(_ConsultaIndividualVar6_QNAME, String.class, ConsultaIndividual.class, value);
    }

}
