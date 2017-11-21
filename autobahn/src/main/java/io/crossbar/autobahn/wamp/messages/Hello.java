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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import io.crossbar.autobahn.wamp.interfaces.IMessage;
import io.crossbar.autobahn.wamp.utils.MessageUtil;

public class Hello implements IMessage {

    public static final int MESSAGE_TYPE = 1;

    public final String realm;
    public final List<String> authMethods;
    public final String authId;
    public final Map<String, Map> roles;

    @Override
    public List<Object> marshal() {
        List<Object> marshaled = new ArrayList<>();
        marshaled.add(MESSAGE_TYPE);
        marshaled.add(realm);
        Map<String, Object> details = new HashMap<>();
        details.put("roles", roles);
        if (authId != null && !authMethods.isEmpty()) {
            details.put("authmethods", authMethods);
            details.put("authid", authId);
        }
        marshaled.add(details);
        return marshaled;
    }

    public static Hello parse(List<Object> wmsg) {
        MessageUtil.validateMessage(wmsg, MESSAGE_TYPE, "HELLO", 3);

        String realm = (String) wmsg.get(1);

        Map<String, Object> details = (Map<String, Object>) wmsg.get(2);
        Map<String, Map> roles = (Map<String, Map>) details.get("roles");

        return new Hello(realm, roles);
    }

    public Hello(String realm, Map<String, Map> roles) {
        this.realm = realm;
        this.authMethods = new ArrayList<>();
        this.authId = null;
        this.roles = roles;
    }

    public Hello(String realm, List<String> authMethods, String authId, Map<String, Map> roles) {
        this.realm = realm;
        this.authMethods = authMethods;
        this.authId = authId;
        this.roles = roles;
    }
}
