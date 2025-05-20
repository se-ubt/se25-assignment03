package de.unibayreuth.se.campuscoffee.domain.ports;

import de.unibayreuth.se.campuscoffee.domain.Pos;
import de.unibayreuth.se.campuscoffee.domain.TestFixtures;
import de.unibayreuth.se.campuscoffee.domain.impl.PosServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PosServiceTest {

    @Mock
    private PosDataService posDataService;

    @InjectMocks
    private PosServiceImpl posService;

    @Test
    void retrieveExpectedNumberOfPosEntries() {
        List<Pos> testFixtures = TestFixtures.getPosList();
        when(posDataService.getAll()).thenReturn(testFixtures);

        List<Pos> retrievedPos = posService.getAll();
        assertEquals(3, retrievedPos.size());
    }
}
