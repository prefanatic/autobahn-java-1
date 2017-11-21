///////////////////////////////////////////////////////////////////////////////
//
//   AutobahnJava - http://crossbar.io/autobahn
//
//   Copyright (c) Crossbar.io Technologies GmbH and contributors
//
//   Licensed under the MIT License.
//   http://www.opensource.org/licenses/mit-license.php
//
///////////////////////////////////////////////////////////////////////////////

package io.crossbar.autobahn.wamp.messages;

import java.util.List;
import java.util.Map;

import io.crossbar.autobahn.wamp.interfaces.IMessage;
import io.crossbar.autobahn.wamp.utils.MessageUtil;

public class Welcome implements IMessage {

    public static final int MESSAGE_TYPE = 2;

    public final long session;
    public final Map<String, Map> roles;
    public final String realm;
    public final String authid;
    public final String authrole;
    public final String authmethod;
    public final String authprovider;

    public Welcome(long session, Map<String, Map> roles, String realm) {
        this.session = session;
        this.roles = roles;
        this.realm = realm;
        this.authid = null;
        this.authrole = null;
        this.authmethod = null;
        this.authprovider = null;
    }

    public Welcome(long session, Map<String, Map> roles, String realm, String authid,
                   String authrole, String authmethod, String authprovider) {
        this.session = session;
        this.roles = roles;
        this.realm = realm;
        this.authid = authid;
        this.authrole = authrole;
        this.authmethod = authmethod;
        this.authprovider = authprovider;
    }

    public static Welcome parse(List<Object> wmsg) {
        MessageUtil.validateMessage(wmsg, MESSAGE_TYPE, "WELCOME", 3);

        long session = (long) wmsg.get(1);

        Map<String, Object> details = (Map<String, Object>) wmsg.get(2);
        Map<String, Map> roles = (Map<String, Map>) details.get("roles");
        String realm = (String) details.get("realm");
        String authId = (String) details.get("authid");
        String authrole = (String) details.get("authrole");
        String authmethod = (String) details.get("authmethod");
        String authprovider = (String) details.get("authprovider");

        return new Welcome(session, roles, realm, authId, authrole, authmethod, authprovider);
    }

    @Override
    public List<Object> marshal() {
        // We are a client library, so don't really need to send a Welcome.
        throw new UnsupportedOperationException("Welcome only to be sent by a server library.");
    }
}
