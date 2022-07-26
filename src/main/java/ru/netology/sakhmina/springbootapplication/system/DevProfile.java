package ru.netology.sakhmina.springbootapplication.system;

public class DevProfile implements SystemProfile{
    @Override
    public String getProfile() {
        return "Current profile is dev";
    }
}
