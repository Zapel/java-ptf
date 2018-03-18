package net.ukr.ptg.github;

import com.google.common.collect.ImmutableBiMap;
import com.jcabi.github.*;
import org.testng.annotations.Test;

import java.io.IOException;

public class GithubTests {

    @Test
    public void testCommits() throws IOException {
        Github github = new RtGithub(" fcde7e6947a6e6badf83cf1a96264243013ba53c");
        RepoCommits commits = github.repos().get(new Coordinates.Simple("Zapel", "java-ptf")).commits();
        for (RepoCommit commit : commits.iterate(new ImmutableBiMap.Builder<String, String>().build())) {
            System.out.println(new RepoCommit.Smart(commit).message());
        }
    }
}
