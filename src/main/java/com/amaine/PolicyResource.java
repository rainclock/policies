package com.amaine;

import com.amaine.dto.Policy;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Set;

@Path("/policies")
public class PolicyResource {
    private Set<Policy> policies = Collections.newSetFromMap(Collections.synchronizedMap(new LinkedHashMap<>()));

    public PolicyResource() {
        policies.add(new Policy("P1"));
        policies.add(new Policy("P2"));
        policies.add(new Policy("P3"));
    }

    @GET
    public Set<Policy> list() {
        return policies;
    }

    @POST
    public Set<Policy> add(Policy fruit) {
        policies.add(fruit);
        return policies;
    }

    @DELETE
    public Set<Policy> delete(Policy policy) {
        policies.removeIf(existing -> existing.policyNumber.contentEquals(policy.policyNumber));
        return policies;
    }
}