package uz.pdp.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping()
@ResponseBody
public class PermissionController {

    @GetMapping("/user")
    @PreAuthorize("hasRole('USER')")
    public String user() {
        return "User Page";
    }

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String admin() {
        return "ADMIN Page";
    }

    @GetMapping("/manager-admin")
    @PreAuthorize("hasAnyRole('MANAGER', 'ADMIN')")
    public String manager() {
        return "Manager, Admin Page";
    }


    @GetMapping("/me")
    @PreAuthorize("hasAuthority('READ_ME')")
    public String me() {
        return "Me";
    }

    @GetMapping("/excel")
    @PreAuthorize("hasAuthority('DOWNLOAD_EXCEL')")
    public String excel() {
        return "Excel";
    }

    @GetMapping("/admin_page")
    @PreAuthorize("hasAnyAuthority('DOWNLOAD_EXCEL', 'UPDATE_MANAGER')")
    public String adminPage() {
        return "Admin PAge";
    }
}
